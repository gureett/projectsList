# Week 0 Project 2

# Declaring Variables
helloValue = "$0"
hValue = "$20"
anyValue = "$100"

# Getting User Input
userInput = input("Greeting: ")

# Making it all lowercase and removing extra spaces
lowerInput = userInput.lower().removeprefix(" ")


# Checking what the user inputs starts with and outputting accordingly
if (lowerInput.startswith("hello")):
    print(f"{helloValue}")
elif (lowerInput.startswith("h")):
    print(f"{hValue}")
else:
    print(f"{anyValue}")