# Week 7 Project 2

# Importing
import re
import sys

# Main
def main():
    print(parse(input("HTML: ")))

# Parse
def parse(s):
    # using re search and grouping
    sLink = re.search(r"<iframe src=\"https?://(www\.)?youtube\.com/embed/([a-zA-Z0-9]+)\"></iframe>", s)
    # Checking if true
    if sLink:
        # returns f string back
        return f"https://youtu.be/{sLink.group(2)}"
    else:
        return None

if __name__ == "__main__":
    main()