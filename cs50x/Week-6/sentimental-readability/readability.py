# TODO
numLetters = 0
numWords = 1
numSentences = 0

text = input("Text: ")

for i in range(len(text)):
    if text[i].isalpha():
        numLetters += 1
    elif text[i].isspace():
        numWords += 1
    elif text[i] == "." or text[i] == "!" or text[i] == "?":
        numSentences += 1


l = numLetters / numWords * 100
s = numSentences / numWords * 100
index = round(0.0588 * l - 0.29 * s - 15.8)


if index > 16:
    print("Grade 16+")
elif index > 1 and index < 16:
    print(f"Grade {index}")
else:
    print("Before Grade 1")
