# Week 0 Problem 5

def main():
    dollars = dollars_to_float(input("How much was the meal? "))
    percent = percent_to_float(input("What percentage would you like to tip? "))
    tip = (dollars * percent)
    print(f"Leave ${tip:.2f}")


def dollars_to_float(d):
    try:
        d = d.replace("$","")
        d = float(d)
        return d
    except:
        print("Error Occured")


def percent_to_float(p):
    try:
        p = p.replace("%", "")
        p = float(p)
        p = p / 100
        return p
    except:
        print("Error Occured")


main()