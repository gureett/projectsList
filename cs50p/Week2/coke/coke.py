# Week 2 Problem 2

from sys import exit

# Declaring variable for money owed
amountDue = 50
changeOwed = 0

# Makes user input into a float and subtract from the amount due
def coinFunc(input):
    global amountDue, changeOwed
    coin = int(input)
    amountDue -= coin
    if (amountDue < 0):
        changeOwed = abs(amountDue)

# Main function
def main():
    # While loop to keep prompting the user while the amount due is not equal to 0
    while amountDue > 0:
        # Gets user input
        print(f"Amount Due: {amountDue}")
        userInput = input("Insert Coin: ")
        # Conditionals to check what was entered
        if (userInput == "25"):
            coinFunc(userInput)
        elif (userInput == "10"):
            coinFunc(userInput)
        elif (userInput == "5"):
            coinFunc(userInput)
    # Prints the change owed
    print(f"Change Owed: {changeOwed}")
    # Exits
    exit()

if __name__ == "__main__":
    main()