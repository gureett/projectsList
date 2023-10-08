# Week 3 Project 4

# Declaring list with values
months = [
    "january",
    "february",
    "march",
    "april",
    "may",
    "june",
    "july",
    "august",
    "september",
    "october",
    "november",
    "december"
]

# While True loop
while True:
    # Getting user input
    s = input("Date: ")

    if (s[0].isalpha() and s.count(",") == 0):
        continue
    elif (s[0].isalpha() and s.count("/") > 0):
        continue

    sFormat = s.replace("/", " ").replace(",", "")

    # try except
    try:
        # Splitting
        month, day, year = sFormat.split()
        # Making day an integer
        day = int(day)
        # Checking if month is numeric
        if month.isnumeric():
            month = int(month)
            if (day >= 1 and day <= 31 and month >= 1 and month <= 12):
                print(f"{year}-{month:02}-{day:02}")
                break
        else:
            if (day >= 1 and day <= 31):
                index = months.index(month.lower())
                index += 1
                print(f"{year}-{index:02}-{day:02}")
                break

    except:
        pass