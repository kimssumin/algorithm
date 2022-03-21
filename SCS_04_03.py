# 두 여왕
# 체스보드에 놓을 수 있는 방법의 수


n = int(input())

ans = 0
row = [0] * n


def is_promising(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False

    return True


def n_queens(x):
    #cnt = 0
    global ans
    if x == 2:
        ans += 1

    else:
        for i in range(n):
            # [x, i]에 퀸을 놓겠다.
            row[x] = i
            if is_promising(x):
                n_queens(x+1)


n_queens(0)
print(ans)
print(row)
'''
from collections import deque
import sys
input = sys.stdin.readline


def dfs():
    dx = [-1, -2, -2, -1, 1, 2, 2, 1]  # 체스 말 움직임1
    dy = [-2, -1, 1, 2, 2, 1, -1, -2]  # 체스 말 움직임2
    chess = [[0] * n for _ in range(n)]
    cnt = 0
    #endX , endY = n-1, n-1

    for i in range(n):
        for j in range(n):
            startX = i, startY = j
            queue = deque([[startX, startY]])
    # if startX == endX and startY == endY:  # 시작과 종점이 같을 때 예외처리
    #     return cnt
            while queue:  # 종료조건and not chess[endX][endY]
                x, y = queue.popleft()
                for a, b in zip(dx, dy):  # zip 을 사용하면 더 빠르게 수행할 수 있다고 한다
                    nx = x + a
                    ny = y + b
                    if 0 <= nx < n and 0 <= ny < n-j:
                        # if not chess[nx][ny]:
                        cnt += 1
                        queue.append([nx, ny])
    return cnt


n = int(input())
print(dfs())
'''
