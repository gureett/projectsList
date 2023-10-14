# Week 7 Project 4

# Importing
import re
import sys

# Main
def main():
    print(count(input("Text: ")))

# Convert
def count(s):
    # Using re.findall
    if found := re.findall("(^|\W)um($|\W)", s, re.IGNORECASE):
        return(len(found))
    else:
        sys.exit(1)

if __name__ == "__main__":
    main()