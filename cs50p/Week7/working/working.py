# Week 7 Project 3

import re
import sys

# Main
def main():
    print(convert(input("Hours: ")))

# Convert
def convert(s):
    # All valid time intervals
    valid_time = "(0?[1-9]|1[0-2]):?\.?([0-5][0-9])? (AM|PM)"
    # Searching
    time = re.search(r"^" + valid_time + " to " + valid_time + "$", s)
    if time:
        # Returning the values after converting it to 24 hour time
        return f"{to_twenty_four(time.group(1), time.group(2), time.group(3))} to {to_twenty_four(time.group(4), time.group(5), time.group(6))}"
    else:
        raise ValueError

# To Twenty Four
def to_twenty_four(h, m, ap):
    # Checking if hour is 12 and ap is AM
    if h == "12" and ap == "AM":
        hour = "00"
    # Checking if hour is 12 and ap is PM
    elif h == "12" and ap == "PM":
        hour = "12"
    # Else
    else:
        # Checking if AM is AM
        if ap == "AM":
            hour = f"{int(h):02}"
        else:
            hour = f"{int(h)+12}"
    # Checking if there is any minutes
    if m == None:
        minute = "00"
    else:
        minute = f"{int(m):02}"

    return f"{hour}:{minute}"

if __name__ == "__main__":
    main()