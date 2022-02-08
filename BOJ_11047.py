#동전 0
#greedy

import sys

input = sys.stdin.readline

n, k = map(int, input().split())
A_l = []

for _ in range(n):
    A_l.append(int(input().strip()))

cnt = 0

for i in reversed(range(len(A_l))):
    cnt += k // A_l[i]
    k = k % A_l[i]

print(cnt)