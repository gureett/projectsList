# Week 6 Project 1

# Importing sys argv
from sys import argv, exit

def main():
    # Checking usage
    if len(argv) < 2:
        # Printing out to user
        exit("Too few command-line arguments")
    elif len(argv) > 2:
        exit("Too many command-line arguments")
    elif argv[1].endswith(".py") != True:
        # Priting out to user
        exit("Not a Python file ")
    lines = count_lines(argv[1])
    print(lines)

def count_lines(file):
    # Try Except
    try:
        # Opening the file
        with open(file, "r") as file:
            # Reading lines to the file
            lines = file.readlines()
    except FileNotFoundError:
        exit("File does not exist")
    else:
        # Setting a counter variable to 0
        ctr = 0
        # Checking each line to see if its a comment or has white space
        for line in lines:
            # If it starts with # meaning comment or all spaces removed is empty then pass without adding to counter
            if line.lstrip().startswith("#") or line.strip() == "":
                pass
            else:
                # Adding to counter and passes
                ctr += 1
                pass
        return ctr

if __name__ == "__main__":
    main()