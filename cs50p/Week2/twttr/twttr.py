# Week 2 Problem 3

# Import re
import re

# Getting user input
userInput = input("Input: ")

# Replacing all vowels with empty characters
output = re.sub('[aeiouAEIOU]', '', userInput, flags=re.I)

# Printing out the output
print(f"Output: {output}")