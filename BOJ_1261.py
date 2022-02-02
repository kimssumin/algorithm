#알고스팟
#BFS

from collections import deque
import sys


m, n = map(int, input().split())
miro = []
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
for _ in range(n):
    miro.append(list(map(int, sys.stdin.readline().strip())))

dist = [[-1] * m for _ in range(n)]
dist[0][0] = 0

def bfs():
    q = deque()
    q.append((0,0))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx , ny = x + dx[i], y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny < m:
                if dist[nx][ny] == -1:
                    if miro[nx][ny] == 0:
                        q.appendleft((nx,ny))
                        dist[nx][ny] = dist[x][y]
                    else :
                        q.append((nx, ny))
                        dist[nx][ny] = dist[x][y] + 1

    print(dist[n-1][m-1])
bfs()
