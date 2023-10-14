# Week 7 Project 1

# Importing
import re
import sys

# Main
def main():
    print(validate(input("IPv4 Address: ")))

# Validate
def validate(ip):
    # Declaring values as variables to make it easier to apply and read
    ip_range = "([0-1]?([0-9]?){2}|2[0-4]?[0-9]?|25[0-5]?)"
    dot = "\."
    if re.search(r"^" + ip_range + dot + ip_range + dot + ip_range + dot + ip_range + "$", ip):
        return True
    else:
        return False

if __name__ == "__main__":
    main()