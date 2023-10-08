# Week 3 Project 1

def main():
    # Getting value
    value = getFraction()

    # Moving the decimal spaces
    value = round(value * 100)

    if value <= 1:
        # Output
        print(f"E")
    elif value >= 99:
        # Output
        print(f"F")
    else:
        # Output
        print(f"{value}%")


def getFraction():
    # While True loop until we get our desired input
    while True:
        # Gets user input
        s = input("Fraction: ")
        # try catch
        try:
            # Turning it into a decimal value and returning
            x, y = s.split("/")
            ans = float(x) / float(y)
            # if statement to check conditions
            if (ans > 1 or x.isalnum() == False or y.isalnum() == False):
                pass
            else:
                return ans
        except (ValueError, ZeroDivisionError):
            pass

main()