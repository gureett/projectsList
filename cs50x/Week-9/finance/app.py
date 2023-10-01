import os

from cs50 import SQL
from flask import Flask, flash, redirect, render_template, request, session
from flask_session import Session
from werkzeug.security import check_password_hash, generate_password_hash

from helpers import apology, login_required, lookup, usd

# Configure application
app = Flask(__name__)

# Custom filter
app.jinja_env.filters["usd"] = usd

# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# Configure CS50 Library to use SQLite database
db = SQL("sqlite:///finance.db")


@app.after_request
def after_request(response):
    """Ensure responses aren't cached"""
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response


@app.route("/")
@login_required
def index():
    """Show portfolio of stocks"""

    # Getting the users stocks and shares
    stocks = db.execute("SELECT symbol, SUM(shares) as total_shares FROM transactions WHERE user_id = :user_id GROUP BY symbol HAVING total_shares > 0", user_id=session["user_id"])

    # Getting the users balance
    cash = db.execute("SELECT cash FROM users where id = :user_id", user_id=session["user_id"])[0]["cash"]

    # Setting variables for all total variables
    total_value = cash
    grand_total = cash

    # Checking over stocks and adding the prices and total value
    for stock in stocks:
        quote = lookup(stock["symbol"])
        stock["name"] = quote["name"]
        stock["price"] = quote["price"]
        stock["value"] = stock["price"] * stock["total_shares"]
        total_value += stock["value"]
        grand_total += stock["value"]

    return render_template("index.html", stocks=stocks, cash=cash, total_value=total_value, grand_total=grand_total)


@app.route("/buy", methods=["GET", "POST"])
@login_required
def buy():
    """Buy shares of stock"""

    # checking request
    if request.method == "POST":
        # setting symbol and shares variable
        symbol = request.form.get("symbol").upper()
        shares = request.form.get("shares")

        # checks if symbol was provided
        if not symbol:
            return apology("Please provide a symbol")
        # checks if the inputed shares is a valid positive integer or not
        elif not shares or not shares.isdigit() or int(shares) <= 0:
            return apology("Please provide a +ve integer number of shares")

        # looks up quote and checks if there is one
        quote = lookup(symbol)
        if quote is None:
            return apology("Symbol Not Found")

        # setting required variables
        price = quote["price"]
        total_cost = int(shares) * price
        # selecting from db
        cash = db.execute("SELECT cash FROM users WHERE id = :user_id", user_id=session["user_id"])[0]["cash"]

        # checking if they have enough to buy
        if cash < total_cost:
            return apology("Not Enough Balance")

        # Update users table
        db.execute("UPDATE users SET cash = cash - :total_cost WHERE id = :user_id", total_cost=total_cost, user_id=session["user_id"])

        # Add the stock purchase to the users history
        db.execute("INSERT INTO transactions (user_id, symbol, shares, price) VALUES (:user_id, :symbol, :shares, :price)", user_id=session["user_id"], symbol=symbol, shares=shares, price=price)

        # Using flash
        flash(f"Bought {shares} shares of {symbol} for {usd(total_cost)}!")

        # Redirect user
        return redirect("/")

    else:
        return render_template("buy.html")


@app.route("/history")
@login_required
def history():
    """Show history of transactions"""
    # getting database for users transactions
    transactions = db.execute("SELECT * FROM  transactions WHERE user_id = :user_id ORDER BY timestamp DESC", user_id=session["user_id"])

    return render_template("history.html", transactions=transactions)


@app.route("/login", methods=["GET", "POST"])
def login():
    """Log user in"""

    # Forget any user_id
    session.clear()

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":
        # Ensure username was submitted
        if not request.form.get("username"):
            return apology("must provide username", 403)

        # Ensure password was submitted
        elif not request.form.get("password"):
            return apology("must provide password", 403)

        # Query database for username
        rows = db.execute("SELECT * FROM users WHERE username = ?", request.form.get("username"))

        # Ensure username exists and password is correct
        if len(rows) != 1 or not check_password_hash(rows[0]["hash"], request.form.get("password")):
            return apology("invalid username and/or password", 403)

        # Remember which user has logged in
        session["user_id"] = rows[0]["id"]

        # Redirect user to home page
        return redirect("/")

    # User reached route via GET (as by clicking a link or via redirect)
    else:
        return render_template("login.html")


@app.route("/logout")
def logout():
    """Log user out"""

    # Forget any user_id
    session.clear()

    # Redirect user to login form
    return redirect("/")


@app.route("/quote", methods=["GET", "POST"])
@login_required
def quote():
    """Get stock quote."""

    # Checks if post
    if request.method == "POST":
        # getting the symbol
        symbol = request.form.get("symbol")
        # looking up quote
        quote = lookup(symbol)
        # if quote is not in database
        if not quote:
            return apology("Invalid Symbol", 400)
        return render_template("quote.html", quote=quote)
    else:
        return render_template("quote.html")


@app.route("/register", methods=["GET", "POST"])
def register():
    """Register user"""
    # clear session
    session.clear()

    if request.method == "POST":
        # check is username was submitted
        if not request.form.get("username"):
            return apology("Please provide username", 400)

        #  check if password was submitted
        elif not request.form.get("password"):
            return apology("Please provide password", 400)

        #  check if password was submitted
        elif not request.form.get("confirmation"):
            return apology("Please confirm password", 400)

        #  check if password and confirmation are the same
        elif request.form.get("password") != request.form.get("confirmation"):
            return apology("Please ensure passwords are the same", 400)

        # giving username its own variable
        formUsername = request.form.get("username")

        # query the database for the new user
        rows = db.execute("SELECT * FROM users WHERE username = ?", formUsername)

        # checking if username already exists
        if len(rows) != 0:
            return apology("Username already exists", 400)

        # insert new user into db
        db.execute("INSERT INTO users (username, hash) VALUES (?, ?)", formUsername, generate_password_hash(request.form.get("password")))

        # query database for the newly inserted user
        rows = db.execute("SELECT * FROM users WHERE username = ?", formUsername)

        # getting session ids for which user is logged in
        session["user_id"] = rows[0]["id"]

        # redirects user back to home page
        return redirect("/")

    else:
        return render_template("register.html")


@app.route("/sell", methods=["GET", "POST"])
@login_required
def sell():
    """Sell shares of stock"""
    # Getting the users stocks
    stocks = db.execute("SELECT symbol, SUM(shares) as total_shares FROM transactions WHERE user_id = :user_id GROUP BY symbol HAVING total_shares > 0", user_id=session["user_id"])

    # if method is post
    if request.method == "POST":
        symbol = request.form.get("symbol").upper()
        shares = request.form.get("shares")

        # checks if symbol was provided
        if not symbol:
            return apology("Please provide a symbol")
        # checks if the inputed shares is a valid positive integer or not
        elif not shares or not shares.isdigit() or int(shares) <= 0:
            return apology("Please provide a +ve integer number of shares")
        else:
            shares = int(shares)

        for stock in stocks:
            if stock["symbol"] == symbol:
                if stock["total_shares"] < shares:
                    return apology("Not Enough Shares")
                else:
                    # get quote
                    quote = lookup(symbol)
                    if quote is None:
                        return apology("Symbol Not Found")
                    price = quote["price"]
                    total_sale = shares * price

                    # Updating the users table
                    db.execute("UPDATE users SET cash = cash + :total_sale WHERE id = :user_id", total_sale=total_sale, user_id=session["user_id"])

                    # Add the sale to the history
                    db.execute("INSERT INTO transactions (user_id, symbol, shares, price) VALUES (:user_id, :symbol, :shares, :price)", user_id=session["user_id"], symbol=symbol, shares=-shares, price=price)

                    # Using flash
                    flash(f"Sold {shares} shares of {symbol} for {usd(total_sale)}!")

                    # redirects user
                    return redirect("/")

        return apology("Symbol Not Found!")

    else:
        return render_template("sell.html", stocks=stocks)
