# Week 2 Problem 4

# Main Method
def main():
    plate = input("Plate: ")
    if is_valid(plate):
        print("Valid")
    else:
        print("Invalid")


# Checks if it is valid
def is_valid(s):
    # Getting length of the string
    length = len(s)
    if (length < 2):
        return False
    # Checking if the first two characters are letter
    if (s[0].isalpha() and s[1].isalpha() != True):
        return False
    # Checking if it is minimum of 2 and max of 6
    if (length >= 2 and length <= 6):
        pass
    else:
        return False
    # Checking if it contains numbers in the middle or if it just ends
    isNum = False
    for c in s:
        # Checking if alpha
        if c.isalpha():
            if isNum:
                return False
        # Checking if it is numeric
        elif c.isnumeric():
            # Checking if it is the first numeric value
            if (isNum == False):
                # If the first numeric value is zero then return false
                if (c == "0"):
                    return False
            isNum = True
        else:
            return False
    # Returns true
    return True


main()