#차이를 최대로
#brute force - 순열

import sys
from itertools import permutations

n = int(input())
a = list(map(int, sys.stdin.readline().split()))

def suma(k):
    sum = 0
    for i in range(len(k)-1):
        sum += abs(k[i] - k[i+1])
    return sum

res = 0
data = permutations(a, n)
for j in data:
    inpu = list(j)
    res = max(res, suma(inpu))

print(res)
