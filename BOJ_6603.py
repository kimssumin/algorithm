#로또
#brute force

from itertools import combinations as com
import sys

input = sys.stdin.readline

while(1):
    S = list(map(int, input().split()))
    if S[0] == 0:
        break
    k = S[0]
    S = S[1:]
    for j in com(S, 6):
        print(' '.join(map(str, j)))
    print()