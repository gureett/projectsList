# Week 0 Project 1

# Getting User Input
userInput = input("What is the Answer to the Great Question of Life, the Universe, and Everything? ")

# Making user input into all uppercase
upperInput = userInput.upper()

# Removing any spaces
upperInput = upperInput.replace(" ", "")

# Checks if the upper input value is one of the below and prints corresponding answercheck50 cs50/problems/2022/python/deep
if (upperInput == "FORTYTWO" or upperInput == "FORTY-TWO" or upperInput == "42"):
    print("Yes")
else:
    print("No")