# Week 0 Project 5

# Main Method
def main():
    # Getting User Input
    userInput = input("What time is it?")

    # Checking if it contains a.m. or p.m.
    if (userInput.lower().endswith("a.m.")):
        # Giving the variable time the user input without any text and spaces
        time = userInput.removesuffix("a.m.").replace(" ", "")
        time = convert(time)
        # Checking if it is breakfast time
        if (time >= 7 and time <= 8):
            print("breakfast time")
    elif (userInput.lower().endswith("p.m.")):
        # Giving the variable time with the user input without any text and spaces
        time = userInput.removesuffix("a.m.").replace(" ", "")
        # Converting
        time = convert(time)
        # Checking which time it is
        if (time >= 12 and time <= 13 or time <= 1):
            print("lunch time")
        elif (time >= 6 and time <= 7):
            print("dinner time")
    else:
        # Converting
        time = convert(userInput)
        # Checking which time it is
        if (time >= 7 and time <= 8):
            print("breakfast time")
        elif (time >= 12 and time <= 13):
            print("lunch time")
        elif (time >= 18 and time <= 19):
            print("dinner time")

# Convert Method
def convert(time):
    # Splits into first and second
    first, second = time.split(":")
    # Converts to hours
    second = float(second) / 60
    # Adds them together
    time = float(first) + second
    # Returns
    return time


if __name__ == "__main__":
    main()