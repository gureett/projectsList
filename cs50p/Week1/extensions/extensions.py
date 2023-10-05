# Week 0 Project 3

gif = "image/gif"
jpg = "image/jpg"
jpeg = "image/jpeg"
png = "image/png"
pdf = "application/pdf"
zip = "application/zip"
txt = "text/plain"
default = "application/octet-stream"

# Getting Users Input
userInput = input("File name: ")

# Making all characters lowercase
lowerInput = userInput.lower().rstrip()

# Checking what it ends with and outputs the approriate message
if (lowerInput.endswith(".gif")):
    print(f"{gif}")
elif (lowerInput.endswith(".jpeg") or lowerInput.endswith(".jpg")):
    print(f"{jpeg}")
elif (lowerInput.endswith(".png")):
    print(f"{png}")
elif (lowerInput.endswith(".pdf")):
    print(f"{pdf}")
elif (lowerInput.endswith(".zip")):
    print(f"{zip}")
elif (lowerInput.endswith(".txt")):
    print(f"{txt}")
else:
    print(f"{default}")