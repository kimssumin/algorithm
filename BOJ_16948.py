#데스나이트
#bfs

import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
r1, c1, r2, c2 = map(int, input().split())
visited = [[-1]*(N) for _ in range(N)]
dy = [-2, -2, 0, 0, 2 ,2]
dx = [-1, 1, -2, 2, -1, 1]
def bfs(y, x):
    q = deque()
    q.append((y,x))
    visited[y][x] = 0
    while q:
        y, x = q.popleft()
        for i in range(6):
            ny, nx = y + dy[i], x + dx[i]
            
            if (0 <= ny < N) and (0 <= nx < N) and visited[ny][nx] == -1:
                q.append((ny, nx))
                visited[ny][nx] = visited[y][x] + 1
                
bfs(r1, c1)
print(visited[r2][c2])



