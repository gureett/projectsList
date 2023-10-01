from cs50 import get_float

# TODO


while True:
    cash = get_float("Change owed: ")
    if cash > 0:
        break

coins = round(cash * 100)

count = 0
while coins > 0:
    if coins >= 25:
        coins -= 25
        count += 1
    elif coins >= 10:
        coins -= 10
        count += 1
    elif coins >= 5:
        coins -= 5
        count += 1
    else:
        coins -= 1
        count += 1


print(count)
