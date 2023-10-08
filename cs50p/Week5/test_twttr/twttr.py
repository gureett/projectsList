import re

def main():
    # Getting user input
    userInput = input("Input: ")

    output = shorten(userInput)

    # Printing out the output
    print(f"Output: {output}")

def shorten(word):
    return re.sub('[aeiouAEIOU]', '', word, flags=re.I)


if __name__ == "__main__":
    main()