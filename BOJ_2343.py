#기타 레슨
#Binary Search

import sys

input = sys.stdin.readline
n, m = map(int, input().split())
arr = list(map(int, input().split()))

tot = sum(arr)
left, right = tot // m, sum(arr)

ans = right

while left <= right:
    mid = (left + right) // 2
    if mid < max(arr):
        left = mid + 1
        continue
    count, temp = 0, 0
    for i in range(len(arr)):
        if arr[i] > mid:
            break
        elif temp + arr[i] <= mid:
            temp += arr[i]
        else:
            temp = arr[i]
            count += 1
    if count <= m-1:
        right = mid - 1
        ans = min(ans, mid)
    else:
        left = mid + 1

print(ans)