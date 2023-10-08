# Week 4 Project 4

# Importing random
import random

number = 0

# While True
while True:
    try:
        n = int(input("Level: "))
    except:
        pass
    else:
        if (n > 0):
            # Getting random number from function
            number = random.randint(1, n)
            # break
            break

# While True
while True:
    try:
        n = int(input("Guess: "))
    except:
        pass
    else:
        # Checking for valid input
        if (n < 1):
            pass

        if (n == number):
            print("Just right!")
            break
        elif (n < number):
            print("Too small!")
            pass
        elif (n > number):
            print("Too large!")
            pass