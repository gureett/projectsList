# Week 0 Project 4

from sys import exit

# Getting User Input
userInput = input("Expression: ")

# Splitting user input into 3 variables
x, y, z = userInput.split(" ")

# try except to try and turn x and z into floats
try:
    x = float(x)
    z = float(z)
except:
    print("Error Occured")
    exit(0)

# Checking what operator y is and doing the calculations
if (y == "+"):
    print(f"{x + z}")
elif (y == "-"):
    print(f"{x - z}")
elif (y == "*"):
    print(f"{x * z}")
elif (y == "/"):
    print(f"{x / z}")
else:
    print("Invalid Operator")
    exit(0)