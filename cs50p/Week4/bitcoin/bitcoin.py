# Week 4 Project 6

# Importing required
from sys import argv
from sys import exit
import requests

# Checking if user satisfied the argument requirements
if len(argv) != 2:
    print("Missing command-line argument")
elif argv[1].isdecimal() == False:
    print("Command-line argument is not a number")

# Declaring empty response variable
response = ""
# Declaring exchange rate usd to 0
exchange_rate_usd = 0

# try except for request
try:
    # Using API and getting information from it
    response = requests.get("https://api.coindesk.com/v1/bpi/currentprice.json")
    # Setting rjson with the information  from response
    rjson = response.json()
    # Setting the exchange rate for USD from the API response, also replaces the comma with nothing to avoid invoking a value error
    exchange_rate_usd = float(((rjson["bpi"])["USD"])["rate"].replace(",",""))
except (requests.RequestException, ValueError):
    exit("Error Occured")

# Doing calculations
amount = float(argv[1]) * exchange_rate_usd

# Printing out to user
print(f"${amount:,.4f}")