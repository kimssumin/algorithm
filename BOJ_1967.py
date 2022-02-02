#트리의 지름 #1167 간소화 ver.
#tree
#bfs

from collections import deque
import sys

V = int(input())

def bfs(start):
    n1, maxdis = 0, 0
    visited = [False] * (V+1)
    visited[start] = True
    q = deque()
    q.append((start, 0))

    while q:
        curr, dis = q.popleft()
        if maxdis < dis:
            maxdis = dis
            n1 = curr
        for cnode, dist in tree[curr]:
            if not visited[cnode]:
                visited[cnode] = True
                q.append((cnode, dis + dist))

    return n1, maxdis

tree= [[] for _ in range(V+1)]
for _ in range(V-1):
    a,b,weight=map(int, input().split())
    tree[a].append((b,weight))
    tree[b].append((a,weight))

n1, maxdis = bfs(1)
n1, maxdis = bfs(n1)
print(maxdis)