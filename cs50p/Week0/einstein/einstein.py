# Week 0 Project 4

# Making a variable for speed of light
speedLight = 300000000

# try except in case of error
try:
    # getting user input
    m = int(input("m: "))

    # doing the calculations
    ans = speedLight * speedLight
    ans *= m

    # outputting
    print(f"E: {ans}")

except:
    print("Please enter a valid number")