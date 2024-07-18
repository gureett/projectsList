def is_alternating(string):
    letter_count = {}

    # Count occurrences of each letter
    for letter in string:
        letter_count[letter] = letter_count.get(letter, 0) + 1

    # Determine if a letter is heavy or light
    heavy_letters = {k for k, v in letter_count.items() if v > 1}
    light_letters = set(string) - heavy_letters

    # Check if letters alternate between light and heavy
    alternating = all((string[i] in light_letters) ^ (string[i + 1] in light_letters) for i in range(len(string) - 1))

    return alternating

# Read input
T, N = map(int, input().split())

results = []

# Process each test case
for _ in range(T):
    string = input()
    result = "T" if is_alternating(string) else "F"
    results.append(result)

# Print the results after all checks
for result in results:
    print(result)