# Week 4 Project 2

# Importing figlet
from pyfiglet import Figlet
import sys

# Making figlet
figlet = Figlet()

# Checking for proper usage
if (len(sys.argv) != 3 and len(sys.argv) != 1):
    sys.exit("Invalid usage")
elif (sys.argv[1] != "-f" and sys.argv[1] != "--font"):
    sys.exit("Invalid usage")
elif (len(sys.argv) == 3):
    # Getting available fonts
    fonts = figlet.getFonts()
    # Checking if user font is in fonts
    if sys.argv[2] not in fonts:
        sys.exit("Invalid usage")
    else:
        figlet.setFont(font=sys.argv[2])

# Getting input
s = input("Input: ")

print(figlet.renderText(s))