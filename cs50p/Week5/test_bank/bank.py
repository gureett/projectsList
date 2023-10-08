

def main():
    # Getting User Input
    userInput = input("Greeting: ")

    val = value(userInput)

    print(f"{val}")

def value(greeting):
    # Splitting it to the first word
    word = greeting.lower().strip()
    # Declaring Variables
    helloValue = 0
    hValue = 20
    anyValue = 100
    # Checking what the user inputs starts with and outputting accordingly
    if "hello" in word:
        return helloValue
    elif word[0] == "h":
        return hValue
    else:
        return anyValue

if __name__ == "__main__":
    main()