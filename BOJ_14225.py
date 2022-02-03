#부분수열의 합
#brute force

from itertools import combinations as com
from collections import Counter

N = int(input())
s = list(map(int, input().split()))

sums = []
for j in range(1, N+1):
    for k in list(com(s,j)):
        sums.append(sum(k))
sums.sort()

res = [i for i in range(1, sums[-1]+2)]
result = Counter(res) - Counter(sums)
print(list(result.keys())[0])

#take1 시간초과
'''from itertools import combinations as com

N = int(input())
s = list(map(int, input().split()))

max = sum(s)
res = [i for i in range(1, max+1)]

for j in range(1, N+1):
    for k in com(s,j):
        r = sum(k)
        if r in res:
            res.remove(r)
print(res[0])   '''