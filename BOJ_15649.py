#N과 M (1)
#brute force

from itertools import permutations

n, m = map(int, input().split())
num = []

for j in range (n):
    num.append(j+1)

for i in permutations(num, m):
    print(' '.join(map(str, i)) , end = '\n')