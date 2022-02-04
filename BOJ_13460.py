#구슬탈출
#brute force
#bfs

import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
board = []
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
visited = [[[[False] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]

xr, yr, xb, yb = 0, 0, 0, 0

for i in range(n):
    board.append(list(input()))
    for j in range(m):
        if board[i][j] == 'R': #빨간구슬
            xr, yr = i, j
        elif board[i][j] == 'B' : #파란구슬
            xb, yb = i, j

def move(x, y , direct):
    cnt = 0
    while board[x + dx[direct]][y + dy[direct]] != '#' and board[x][y] != 'O':
        x += dx[direct]
        y += dy[direct]
        cnt += 1
    return x, y, cnt

def bfs(xr, yr, xb, yb):
    queue = deque()
    queue.append((xr, yr, xb, yb, 1))

    while queue:
        xr, yr, xb, yb, cnt = queue.popleft()
        visited[xr][yr][xb][yb] = True
        if cnt > 10:
            print(-1)
            exit(0)
        for i in range(4):
            nxr, nyr, rcnt = move(xr, yr, i)
            nxb, nyb, bcnt = move(xb, yb, i)

            if board[nxb][nyb] != 'O':
                if board[nxr][nyr] == 'O':
                    print(cnt)
                    exit(0)
                if nxr == nxb and nyr == nyb:
                    if rcnt > bcnt:
                        nxr -= dx[i]
                        nyr -= dy[i]
                    else:
                        nxb -= dx[i]
                        nyb -= dy[i]
                if not visited[nxr][nyr][nxb][nyb]:
                    visited[nxr][nyr][nxb][nyb] = True
                    queue.append((nxr, nyr, nxb, nyb, cnt+1))
    print(-1)
    return


bfs(xr, yr, xb, yb)