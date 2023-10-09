# Week 6 Project 4

# Importing
import os
from PIL import Image, ImageOps
from sys import argv, exit

def main():
    # Checking command line arguments
    if len(argv) < 3:
        exit("Too few command-line arguments")
    elif len(argv) > 3:
        exit("Too many command-line arguments")
    else:
        # Checking if the giving arguments are valid formats
        formats = [".png",".jpg", ".jpeg"]
        # Getting the extensions
        input = (os.path.splitext(argv[1]))[1].lower()
        output = (os.path.splitext(argv[2]))[1].lower()
        # Checking if input extension is one of the compatible formats
        if input not in formats:
            exit("Invalid output")
        # Checking if input and output have the same extension
        elif input != output:
            exit("Input and output have different extensions")
        else:
            fit_shirt(argv[1], argv[2])

def fit_shirt(before, after):
    # try except
    try:
        # opening shirt
        with Image.open("shirt.png") as shirt:
            # opening the input
            with Image.open(before) as file:
                # Cropping the image
                cropped = ImageOps.fit(file, shirt.size)
                # Pasting the shirt
                cropped.paste(shirt, mask = shirt)
                # Saving the shirt
                cropped.save(after)
    except FileNotFoundError:
        exit(f"Input does not exist")


if __name__ == "__main__":
    main()