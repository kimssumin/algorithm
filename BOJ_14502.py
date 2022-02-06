#연구소
#bfs

#pypy3 풀이

import sys
from collections import deque
import copy
from unittest import result

input = sys.stdin.readline
n, m = map(int, input().split())
maps = []
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
visited = [[-1] * m for i in range(n)]
for _ in range(n):
    maps.append(list(map(int, input().split())))

def bfs():
    q = deque()
    temp = copy.deepcopy(maps)
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 2:
                q.append((i, j))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if temp[nx][ny] == 0:
                temp[nx][ny] = 2
                q.append((nx, ny))

    global result
    cnt = 0
    for i in range(n):
        cnt += temp[i].count(0)
    result = max(result, cnt)

def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 0:
                maps[i][j] = 1
                wall(cnt+1)
                maps[i][j] = 0

result = 0
wall(0)
print(result)