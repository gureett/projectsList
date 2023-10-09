# Week 6 Project 2

# Importing sys argv
import csv
from sys import argv, exit
import tabulate

def main():
    # Checking usage
    if len(argv) < 2:
        # Printing out to user
        exit("Too few command-line arguments")
    elif len(argv) > 2:
        exit("Too many command-line arguments")
    elif not (argv[1].endswith(".csv")):
        # Priting out to user
        exit("Not a CSV file ")
    table = read_csv(argv[1])
    print(table)
def read_csv(file):
    # try except
    try:
        with open(file) as csvFile:
            reader = csv.reader(csvFile)
            return tabulate.tabulate(reader, headers="firstrow", tablefmt="grid")
    except FileNotFoundError:
        sys.exit("File does not exist")


if __name__ == "__main__":
    main()