# 두 여왕
# 체스보드에 놓을 수 있는 방법의 수
n = int(input())

ans = 0


def is_promising(x):
    if x == 0:
        return True
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False

    return True


def n_queens(x):
    global ans
    if x == 2*i + (a * 1):
        # print(row)
        ans += 1

    else:
        for j in range(n):
            # [x, i]에 퀸을 놓겠다.
            row[x] = j
            if is_promising(x):
                n_queens(x+i)  # 2)


for a in range(0, n-1):
    for i in range(1, n-a):
        row = [100] * n
        n_queens(a)
# for i in range(2, n):
# row = [100] * n
# n_queens(2)


print(ans)
'''
n = int(input())

ans = 0
row = [0] * n
visited = [False for _ in range(n)]


def is_promising(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False

    return True


def n_queens(x):
    #nt = 0
    global ans
    if x == n:
        ans += 1

    elif x >= 2 and x != n:
        print(row)
        ans += 1
        row[x-1] = 0
        for i in range(n):
            if visited[i]:
              continue
            row[x] = i
            if is_promising(x):
                visited[i] = True
                n_queens(0)

    else:
        for i in range(n):
            # [x, i]에 퀸을 놓겠다.
            if visited[i]:
              continue
            row[x] = i
            if is_promising(x):
                visited[i] = True
                n_queens(x+1)
                visited[i] = False
                #cnt += 1


n_queens(0)
print(ans)
'''
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
