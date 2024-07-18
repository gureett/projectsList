def count_matching_hats(N, hats):
    count = 0
    for i in range(N):
        if hats[i] == hats[(i + N // 2) % N]:
            count += 1
    return count

# Read input
N = int(input())
hats = []
for _ in range(N):
    hats.append(int(input()))

# Call the function and print the result
result = count_matching_hats(N, hats)
print(result)