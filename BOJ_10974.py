#brute force
#모든 순열

from itertools import permutations
n = int(input())
num = []

for i in range(1,n+1):
    num.append(i)

data = permutations(num, n)
for i in data:
    print(' '.join(map(str, i)))