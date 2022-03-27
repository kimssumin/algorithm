# 리스트 값을 오름차순으로 정렬한 후 왼쪽방향으로 몇번 rotation 이동

import sys

A = list(map(int, input().split()))

find1 = len(A) // 2
a = False

for i in range(1, find1):
    if A[i] <= A[i-1]:
        k = i
        print(len(A) - k)
        break
    if i == find1 - 1:
        a = True

if a == True:
    for j in range(find1, len(A)):
        if A[j] <= A[j-1]:
            k = j
            print(len(A) - k)
            break
        if j == len(A)-1:
            print(0)
