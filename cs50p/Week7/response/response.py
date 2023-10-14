import validators

# Main
def main():
    print(check(input("What's your email address? ")))

def check(s):
    # Using validators to check emails and the string
    if validators.email(s) == True:
        return "Valid"
    else:
        return "Invalid"

if __name__ == "__main__":
    main()