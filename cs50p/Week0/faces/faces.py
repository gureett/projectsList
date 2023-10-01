# Week 0 Project 3

def main():
    # Getting users input
    userInput = input();
    # calling convert
    convert(userInput)

def convert(strIn):
    # Replacing :) or :( with corresponding values
    output = strIn.replace(":)","🙂").replace(":(","🙁")
    # Outputting
    print(f"{output}")

main()