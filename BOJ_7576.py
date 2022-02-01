#토마토
#graph
#bfs

from collections import deque
import sys


m, n = map(int, input().split())
toma = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = 0
queue = deque([])

for _ in range(n):
    toma.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    for j in range(m):
        if toma[i][j] == 1:
            queue.append([i,j])

def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            if 0 <= nx < n and 0 <= ny < m and toma[nx][ny] == 0:
                toma[nx][ny] = toma[x][y] + 1 #토마토를 익히면서 횟수 +1
                queue.append([nx, ny])

bfs()
for i in toma:
    for j in i:
        #토마토를 익히지 못했다면 -1
        if j == 0:
            print(-1)
            exit(0)
    # 다 익혔다면 최댓값이 정답
    result = max(result, max(i))
# 처음 시작을 1로 표현했으니 1을 빼준다.
print(result - 1)
