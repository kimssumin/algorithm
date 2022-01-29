import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    ls = []
    n = int(input())
    for k in range(2):
        ls.append(list(map(int, input().split())))
    for i in range(1, n):
        if i == 1:
            ls[0][i] = ls[0][i] + ls[1][i-1]
            ls[1][i] = ls[1][i] + ls[0][i-1]
        else:
            ls[0][i] = ls[0][i] + max(ls[1][i-1], ls[1][i-2])
            ls[1][i] = ls[1][i] + max(ls[0][i-1], ls[0][i-2])
    res = max(ls[0][n-1], ls[1][n-1])
    print(res)
