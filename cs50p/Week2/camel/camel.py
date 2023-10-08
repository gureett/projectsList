# Week 2 Project 1

# Getting User Input
userInput = input("camelCase: ")

# Declaring empty variable
output = ""

# Iterating over each character and adding to an empty string
for c in userInput:
    if (c.isupper()):
        output += "_" + c.lower()
    else:
        output += c

# Printing out result
print(f"snake_case: {output}")