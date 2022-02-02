#트리의 지름
#BFS, DFS 모두 가능
#tree

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
for _ in range(V):
    line = list(map(int, sys.stdin.readline().split()))
    parent = line[0]
    for i in range(1, len(line)-1, 2):
        c, d = line[i], line[i+1]
        tree[parent].append((c, d))

n1, maxdis = bfs(1)
n1, maxdis = bfs(n1)
print(maxdis)