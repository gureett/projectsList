# Week 3 Project 3

from sys import exit

# Creating empty dictionary
items = {}

while True:
    # try catch
    try:
        # Getting user input
        s = input()
        s = s.upper()

        # checking if its already in the dictionary
        if s in items:
            items[s] += 1
        else:
            items[s] = 1

    except EOFError:
        # Sorts in alphabetical order
        # Makes a list of all the keys
        itemKeys = list(items.keys())
        # Sorts them
        itemKeys.sort()
        # Makes a new dictionary rearranging them
        sortedItems = {i: items[i] for i in itemKeys}
        # Setting the original dictionary to these new values
        items = sortedItems
        # Iterates over each item
        for item in items:
            print(f"{items[item]} {item}")
        exit(0)