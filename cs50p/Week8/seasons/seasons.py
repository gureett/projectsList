# Week 8 Project 1

# Importing
import inflect
from datetime import date
from operator import sub
from sys import exit

# Inflect Engine
ie = inflect.engine()

# Main
def main():
    try:
        # Gets date from user
        date_of_birth = input("Date of Birth: ")
        # Prints out the converted version of the subtractions of todays date and the date the user entered
        print(convert(sub(date.today(), date.fromisoformat(date_of_birth)).days))
    except ValueError:
        exit("Invalid date")

# Convert
def convert(time):
    try:
        # Minutes in a Year
        minutesInYear = 1440
        # Conversion and return
        minutes = time * minutesInYear
        return f"{(ie.number_to_words(minutes, andword='')).capitalize()} minutes"
    except ValueError:
        exit("Invalid date")

if __name__ == "__main__":
    main()