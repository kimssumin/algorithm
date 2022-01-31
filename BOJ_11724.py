#연결요소의 개수
#graph
#dfs

import sys
sys.setrecursionlimit(10000)

n, m = map(int, input().split())
arr =[[] for _ in range(n+1)]
visited = [False] * (n+1)
cnt = 0

for _ in range(m):
    u,v = map(int, sys.stdin.readline().split())
    arr[u].append(v)
    arr[v].append(u)

def dfs(v):
    visited[v] = True
    for i in arr[v]:
        if not visited[i]:
            dfs(i)

for j in range(1, n+1):
    if not visited[j]:
        dfs(j)
        cnt += 1
print(cnt)
