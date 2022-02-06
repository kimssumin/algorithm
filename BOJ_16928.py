#뱀과 사다리게임
#bfs

import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
move = [i for i in range(101)]
visited = [-1] * 101
for _ in range(n):
    x, y = map(int, input().split())
    move[x] = y    
for _ in range(m):
    u, v = map(int, input().split())
    move[u] = v

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = 0
    while q:
        start = q.popleft()
        for i in range(1,7):
            x = start + i
            if x > 100:
                continue
            if visited[move[x]] == -1:
                q.append(move[x])
                visited[move[x]] = visited[start] + 1
                if move[x] == 100:
                    print(visited[100])
                    return;
bfs(1)



