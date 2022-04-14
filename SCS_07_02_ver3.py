import sys


def countSmaller(arr, N, value, ind):

    # Stores the count of integers
    count = 0

    # Iterate the given array
    for i in range(N):
        if (arr[i] < value) and arr_q[i] < arr_q[ind]:
            count += 1

    # Return total count
    return count

# Function to find number of integers
# greater than value in range [i, N]


def countLarger(arr, i, N, value, ind):

    # Stores the count of integers
    count = 0

    # Iterate the given array
    while (i < N):
        if (arr[i] > value) and arr_q[i] > arr_q[ind]:
            count += 1
        i += 1

    # Return total count
    return count

# Function to find the count of triplets
# whose indices and elements at that indices
# are also in increasing order


def countTriplets(arr,  N):

    # Stores the count of valid triplets
    totalCount = 0

    # Loop to iterate over the array
    for i in range(0, N - 1):

        # Count of smaller elements than
        # arr[i] in range [0, i-1]
        K1 = countSmaller(arr, N, arr[i], i)

        # Count of greater elements than
        # arr[i] in range [i+1, N]
        K2 = countLarger(arr, 0, N, arr[i], i)

        # Add to total count
        totalCount += K1 * K2

    # Return Answer
    return totalCount


input = sys.stdin.readline
n = int(input())
arr_p = list(map(int, input().split()))
arr_q = list(map(int, input().split()))

print(countTriplets(arr_p, n))
