#greedy
#전구와 스위치

import sys
import copy

input = sys.stdin.readline 

n = int(input())
cnt = 0
a = list(map(int, input().strip()))
light1 = copy.deepcopy(a)
light2 = copy.deepcopy(a)
answer = list(map(int, input().strip()))

def two_flip(i, j):
    A[i] = 1 - A[i]
    A[j] = 1 - A[j]

def three_flip(i, j, k):
    A[i] = 1 - A[i]
    A[j] = 1 - A[j]
    A[k] = 1 - A[k]

for i in range(2):
    A = light1 if i == 0 else light2

    cnt = 0
    for j in range(n):
        if j == 0:
            if i == 0 and A != answer:
                cnt += 1
                two_flip(j, j+1)

        elif 1 <= j <= n-2:
            if A[j-1] != answer[j-1]:
                cnt += 1
                three_flip(j-1, j, j+1)

        elif j == n-1:
            if A[j-1] != answer[j-1]:
                cnt += 1
                two_flip(j-1, j)

    if A == answer:
        print(cnt)
        break

if A != answer:
    print(-1)
