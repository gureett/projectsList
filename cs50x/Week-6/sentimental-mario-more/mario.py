from cs50 import get_int


# TODO
def main():
    height = 0
    while True:
        height = get_int("Height: ")
        if height > 0 and height <= 8:
            break
    for i in range(1, height + 1):
        for j in range(1, height + 1):
            if j > (height - i):
                print("#", end="")
            else:
                print(" ", end="")
            if j == height:
                print(" ", "#" * i, end="")
        print()


main()
