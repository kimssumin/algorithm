#N과 M(2)
#brute force  

from itertools import combinations

n, m = map(int ,input().split())
num = []

for i in range(n):
    num.append(i+1)

data = combinations(num, m)
for j in data:
    print(' '.join(map(str, j))) #tuple -> str