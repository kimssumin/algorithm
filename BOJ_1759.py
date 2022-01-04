#암호만들기 using combinations

import sys
import itertools
from itertools import combinations
input = sys.stdin.readline

ahdma = ['a','e','i','o','u']

L, C = map(int, input().split())
lett = list(map(str, input().split()))
lett.sort()
combi = combinations (lett, L)

for i in combi:
    w = 0
    a =0
    for j in range(L):
        if i[j] in ahdma:
            a += 1
        else :
            w += 1
    if a >= 1 and w >=2:
        print(''.join(i))

