import csv
import sys

nm = "name"


def main():
    # TODO: Check for command-line usage
    if len(sys.argv) < 3:
        print("Usage: python dna.py data.csv sequence.txt")
        sys.exit(1)
    # TODO: Read database file into a variable
    # Variable to store the file
    databaseFile = sys.argv[1]
    # using with open to open the database file
    with open(databaseFile) as df:
        # setting variable to the csv Dict Reader
        reader = csv.DictReader(df)
        # creates a variable and store all the information in the csv file
        database = [row for row in reader]

    # TODO: Read DNA sequence file into a variable
    # Variable to store the file
    dnaFile = sys.argv[2]
    # using with open to open the dna file
    with open(dnaFile) as dnaf:
        # reading the line from the txt file and setting it to sequence
        sequence = dnaf.read()

    # TODO: Find longest match of each STR in DNA sequence
    strCount = {}
    # checking the keys of the database dictionary
    for key in database[0].keys():
        # if k = name, continue the loop and ignore it
        if key == nm:
            continue
        # else strCount at index k = to the result from longest_match function
        else:
            strCount[k] = longest_match(sequence, k)
    # TODO: Check database for matching profiles
    # Checks r in database
    for row in database:
        # set match to true
        match = True
        # k in the keys of r
        for key in row.keys():
            # if k == key of r then continue
            if key == nm:
                continue
            # if the integer value of r[index of k] is not = to strCount[index of k] then match = false and break
            elif int(row[key]) != strCount[key]:
                match = False
                break
        # if there is a match print that name and return
        if match:
            print(row[nm])
            return

    print("No match")


def longest_match(sequence, subsequence):
    """Returns length of longest run of subsequence in sequence."""

    # Initialize variables
    longest_run = 0
    subsequence_length = len(subsequence)
    sequence_length = len(sequence)

    # Check each character in sequence for most consecutive runs of subsequence
    for i in range(sequence_length):
        # Initialize count of consecutive runs
        count = 0

        # Check for a subsequence match in a "substring" (a subset of characters) within sequence
        # If a match, move substring to next potential match in sequence
        # Continue moving substring and checking for matches until out of consecutive matches
        while True:
            # Adjust substring start and end
            start = i + count * subsequence_length
            end = start + subsequence_length

            # If there is a match in the substring
            if sequence[start:end] == subsequence:
                count += 1

            # If there is no match in the substring
            else:
                break

        # Update most consecutive matches found
        longest_run = max(longest_run, count)

    # After checking for runs at each character in seqeuence, return longest run found
    return longest_run


main()
