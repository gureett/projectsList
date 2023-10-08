# Week 3 Project 2

from sys import exit

# Making dictionary with menu items
menu = {
    "baja taco": 4.00,
    "burrito": 7.50,
    "bowl": 8.50,
    "nachos": 11.00,
    "quesadilla": 8.50,
    "super burrito": 8.50,
    "super quesadilla": 9.50,
    "taco": 3.00,
    "tortilla salad": 8.00
}

# Declaring total
total = 0

# While True loop
while True:
    # Getting user input
    try:
        s = input("Item: ")
        index = s.lower()
    except (EOFError):
        exit(0)
    else:
        if index in menu:
            total += menu[index]
            print(f"Total: ${total}0")