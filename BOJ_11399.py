#ATM
#greedy

import sys

N = int(input())
Pi = list(map(int, sys.stdin.readline().split()))
Pi.sort()
result = 0

for i in range(N):
    for j in range(i+1):
        result = result + Pi[j]
print(result)