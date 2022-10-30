from collections import deque

n, k, m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))
ans = 0
start_list = []
now_stone = [(i, j) for i in range(n) for j in range(n) if board[i][j] == 1]
removecandidate = []

q = deque()
visited = [[False for _ in range(n)] for _ in range(n)]


def can_go(x, y):
    if 0 <= x and x < n and 0 <= y and y < n:
        if not board[x][y] and not visited[x][y]:
            return True


def bfs():
    while q:
        x, y = q.popleft()
        dxs, dys = [1, -1, 0, 0], [0, 0, 1, -1]
        for dx, dy in zip(dxs, dys):
            nx, ny = x+dx, y+dy
            if can_go(nx, ny):
                visited[nx][ny] = True
                q.append((nx, ny))


def case_cnt():
    for x, y in removecandidate:
        board[x][y] = 0
    for i in range(n):
        for j in range(n):
            visited[i][j] = False

    for x, y in start_list:
        q.append((x, y))
        visited[x][y] = True

    bfs()
    for x, y in removecandidate:
        board[x][y] = 1  # 원래대로 되돌림
    cnt = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                cnt += 1

    return cnt


def case(i, cnt):
    global ans

    if i == len(now_stone):
        if cnt == m:
            ans = max(ans, case_cnt())
        return
    removecandidate.append(now_stone[i])
    case(i+1, cnt+1)
    removecandidate.pop()
    case(i+1, cnt)


for _ in range(k):
    r, c = tuple(map(int, input().split()))
    start_list.append((r - 1, c - 1))

case(0, 0)

print(ans)
