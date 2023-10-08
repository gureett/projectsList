def main():
    s = input("Fraction: ")
    frac = convert(s)
    out = gauge(frac)
    print(out)

def convert(fraction):
    # Turning it into a decimal value and returning
    x, y = fraction.split("/")
    if y == 0:
        raise ZeroDivisionError
    ans = float(x) / float(y)
    # if statement to check conditions
    if (ans > 1 or x.isalnum() == False or y.isalnum() == False):
        raise ValueError
    else:
        return round(ans * 100)

def gauge(percentage):
    if percentage <= 1:
        return "E"
    elif percentage >= 99:
        # Output
        return "F"
    else:
        # Output
        return f"{percentage}%"

if __name__ == "__main__":
    main()