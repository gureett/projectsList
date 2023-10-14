def symmetric_crop(N, heights):
    # Initialize an empty list to store the minimum asymmetric values for each crop length
    min_asymmetric_values = []

    # Iterate through all possible crop lengths, from 1 to N
    for crop_length in range(1, N + 1):
        asymmetric_values = []  # Initialize a list to store asymmetric values for each crop starting position

        # Iterate through all possible starting positions for the current crop length
        for i in range(N - crop_length + 1):
            # Extract the current crop by slicing the heights list
            crop = heights[i:i + crop_length]

            symmetric_diff = 0  # Initialize the symmetric difference for this crop

            # Calculate the symmetric difference by comparing heights at equidistant positions from the center
            for j in range(crop_length // 2):
                symmetric_diff += abs(crop[j] - crop[crop_length - 1 - j])

            # Add the symmetric difference for this crop to the list of asymmetric values
            asymmetric_values.append(symmetric_diff)

        # Find the minimum asymmetric value for this crop length and store it
        min_asymmetric_values.append(min(asymmetric_values))

    # Return the list of minimum asymmetric values for all crop lengths
    return min_asymmetric_values

# Input
N = int(input())  # Read the number of mountains
heights = list(map(int, input().split()))  # Read the heights of the mountains as a list

# Calculate and print the results
result = symmetric_crop(N, heights)  # Call the symmetric_crop function to calculate minimum asymmetric values
print(" ".join(map(str, result)))  # Print the minimum asymmetric values as space-separated strings