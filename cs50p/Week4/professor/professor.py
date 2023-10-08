# Week 4 Project 5

# Importing random
import random

# Main Method
def main():
    # Getting level using the method and giving it to a variable named level
    level = get_level()
    # Declaring variable for correct answers
    correct_ans = 0
    # for loop for 10 iterations
    for i in range(10):
        # Generating random integers
        x = generate_integer(level)
        y = generate_integer(level)

        # Making a counter variable
        ctr = 0
        # Making an answer key
        ans_key = x + y

        # Giving user 3 tries
        while (ctr <= 3):
            # checking if ctr = 3 and if so then tells the user the answers
            if (ctr == 3):
                print(f"{x} + {y} = {x+y}")
                break
            else:
                # try except
                try:
                    # Getting user input
                    ans = int(input(f"{x} + {y} = "))
                except:
                    pass
                else:
                    # Checking if the answer is correct
                    if ans == ans_key:
                        # Adds 1 to correct answer and breaks out of loop
                        correct_ans += 1
                        break
                    else:
                        # Outputs EEE
                        print("EEE")
                        # Adds counter by 1 and pass
                        ctr += 1
                        pass
    # Printing out correct amount of answers
    print(f"{correct_ans}")


# Get Level Method
def get_level():
    # While true until the user cooperates
    while True:
        # try except
        try:
            # getting user input
            n = int(input("Level: "))
        except ValueError:
            pass
        else:
            # Checking if the level given is valid
            if (n >= 1 and n <= 3):
                return n

# Generate Integer Method
def generate_integer(level):
    if level == 1:
        return random.randint(0, 9)
    elif level == 2:
        return random.randint(10, 99)
    elif level == 3:
        return random.randint(100, 999)
    else:
        raise ValueError

# Running program
if __name__ == "__main__":
    main()