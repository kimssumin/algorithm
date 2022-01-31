#graph
#BFS, DFS

# Depth First Search
def dfs(n):
    print(n, end=' ')
    visited[n] = True
    for i in graph[n]:
        if not visited[i]:
            dfs(i) #재귀

# Breadth First Search
def bfs(n):
    queue = deque([n]) #deque([start])
    visited[n] = True #현재노드 방문처리
    while queue: #큐가 빌때까지 반복
        v = queue.popleft()
        print(v, end= ' ') #큐에서 하나의 원소를 뽑아 출력
        for i in graph[v]: #해당원소와 연결된 , 아직 방문하지 않은 원소들을 큐에 삽입
            if not visited[i]:
                queue.append(i)
                visited[i] = True

import sys
from collections import deque

# node, branch, first node
n, m, v = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n + 1)

# make adjacency list
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

# sort adjacency list
for i in range(1, n+1):
    graph[i].sort()

dfs(v)

# initialize check list
visited = [False] * (n + 1)
print()
bfs(v)