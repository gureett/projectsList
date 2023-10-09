# Week 6 Project 3

# Importing sys argv
import csv
from sys import argv, exit

def main():
    # Checking usage
    if len(argv) < 3:
        # Printing out to user
        exit("Too few command-line arguments")
    elif len(argv) > 3:
        exit("Too many command-line arguments")
    elif not (argv[1].endswith(".csv") or argv[2].endswith(".csv")):
        # Priting out to user
        exit("Not a CSV file ")
    clean_csv(argv[1], argv[2])

def clean_csv(before,after):
    try:
        # Opening before
        with open(before) as file:
                # Reading it in Dict Reader
                reader = csv.DictReader(file)
                # Opening after as newFile
                with open(after, "w") as newFile:
                    # Writing Header
                    writer = csv.DictWriter(newFile, fieldnames = ["first", "last", "house"])
                    writer.writeheader()
                    # For Loop for each name and house
                    for name in reader:
                        last, first = name["name"].replace(" ", "").split(",")
                        house = name["house"]
                        # Writing it to the file
                        writer.writerow({"first": first, "last": last, "house": house})
    except FileNotFoundError:
        exit(f"Could not read {before}")


if __name__ == "__main__":
    main()