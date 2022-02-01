#나이트의 이동
#graph
#bfs

import sys
from collections import deque

dx = [-2, -1, 1, 2, -2, -1, 1, 2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

def bfs(x, y, gx, gy):
    queue = deque()
    queue.append((x,y))
    while queue:
        x, y = queue.popleft()
        if x == gx and y == gy:
            return graph[x][y]
            break
        for i in range(8):
            nx , ny = dx[i] + x, dy[i] + y
            if nx < 0 or ny < 0 or nx >= I or ny >= I:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    
            
T = int(input())
for _ in range(T):
    I = int(input())
    graph = [[0] * I for _ in range(I)]
    input = sys.stdin.readline
    x, y = map(int, input().split())
    gx, gy = map(int, input().split())
    print(bfs(x, y, gx, gy))

