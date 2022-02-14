#이진탐색
#숫자카드2

import sys

nl = int(input())
N = sorted(map(int, sys.stdin.readline().split()))
ml = int(input())
M = list(map(int, sys.stdin.readline().split()))

count = []

def binary(n, N, start, end):
    if start > end:
        re
    mid = (start+ end)//2
    if n == N[mid]:
        return N[start:end+1].count(n)
    elif n < N[mid]:
        return binary(n, N , start, mid-1)
    else:
        return binary(n, N, mid+1, end)

cnt = {}
for n in N:
    start = 0
    end = len(N)- 1
    if n not in cnt:
        cnt[n] = binary(n, N, start, end)

print(' '.join(str(cnt[x]) if x in cnt else '0' for x in M))