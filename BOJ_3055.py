#탈출
#bfs

import sys
from collections import deque

input = sys.stdin.readline
r, c = map(int, input().split())

graph = [list(input().strip()) for _ in range(r)]
distance = [[0] *c for _ in range(r)]
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
queue = deque()

def bfs(Dx,Dy):
    while queue:
        x,y = queue.popleft()
        if graph[Dx][Dy] == 'S': #비버의집 위치가 S이면 distance 반환
            return distance[Dx][Dy]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < r and 0 <= ny < c:
                if (graph[nx][ny] == '.' or graph[nx][ny] == 'D') and graph[x][y] == 'S': #현재위치가 S이면 고슴도치가 움직일 차례 (고슴도치는 . 이거나 D일때만 이동가능)
                    graph[nx][ny] = 'S'
                    distance[nx][ny] = distance[x][y] + 1
                    queue.append((nx,ny))
                elif (graph[nx][ny] =='.' or graph[nx][ny] =='S') and graph[x][y] == '*': #현재위치가 * 이면 물이 움직일 차례 (물은 . 와 S일때만 이동 가능)
                    graph[nx][ny] = '*'
                    queue.append((nx,ny))
    return "KAKTUS"


for x in range(r):
    for y in range(c):
        if graph[x][y] == 'S':
            queue.append((x,y))
        elif graph[x][y] == 'D':
            Dx,Dy = x,y

for x in range(r):
    for y in range(c):
        if graph[x][y] == '*':
            queue.append((x,y))

print(bfs(Dx,Dy))