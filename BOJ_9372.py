#graph, tree
#모든 국가가 연결되어있어서 N-1만 필요

import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    for _ in range(m):
        a, b = map(int, input().split())
    print(n-1)