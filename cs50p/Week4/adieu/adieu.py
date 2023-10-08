# Week 4 Project 3

# Import inflect
import inflect

p = inflect.engine()

# Empty List
list = []

# Empty String
output = ""

# While true loop
while True:
    # try catch
    try:
        list.append(input("Name: "))
    except EOFError:
        break

# Adding all names
output = p.join((list))

# Outputting to user
print(f"Adieu, adieu, to {output}")