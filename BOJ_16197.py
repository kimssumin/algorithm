#두 동전
#brute force
#bfs

import sys
from collections import deque

board = []
o = []

n, m = map(int, input().split())
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]
for i in range(n):
    board.append(list(sys.stdin.readline().strip()))
    for j in range(m):
        if board[i][j] == "o":
            o.append((i,j))

def bfs():
    queue = deque()
    queue.append((o[0][0], o[0][1], o[1][0], o[1][1], 0))
    while queue:
        x1, y1, x2, y2, cnt = queue.popleft()
        if cnt >= 10:
            return -1
        for i in range(4):
            nx1 = x1 + dx[i]
            ny1 = y1 + dy[i]
            nx2 = x2 + dx[i]
            ny2 = y2 + dy[i]
            if 0 <= nx1 < n and 0 <= ny1 < m and 0 <= nx2 < n and 0 <= ny2 < m:
                # 벽이라면
                if board[nx1][ny1] == "#":
                    nx1, ny1 = x1, y1
                if board[nx2][ny2] == "#":
                    nx2, ny2 = x2, y2
                queue.append((nx1, ny1, nx2, ny2, cnt + 1))
            elif 0 <= nx1 < n and 0 <= ny1 < m:  # c2가 떨어진 경우
                return cnt + 1
            elif 0 <= nx2 < n and 0 <= ny2 < m:  # c1가 떨어진 경우
                return cnt + 1
            else:  # 둘 다 떨어진 경우 무시
                continue
    return -1

print(bfs())  