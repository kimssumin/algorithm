# 갈 수 있는 곳들

from collections import deque

n, k = tuple(map(int, input().split()))
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

bfs_q = deque()
visited = [
    [False for _ in range(n)]
    for _ in range(n)
]


def in_range(x, y):
    return 0 <= x and x < n and 0 <= y and y < n


def can_go(x, y):
    return in_range(x, y) and not grid[x][y] and \
        not visited[x][y]


def bfs():
    # queue에 남은 것이 없을때까지 반복
    while bfs_q:
        # queue에서 가장 먼저 들어온 원소를 pop
        x, y = bfs_q.popleft()

        dxs, dys = [1, -1, 0, 0], [0, 0, 1, -1]

        # queue에서 뺀 원소의 위치를 기준으로 4방향을 확인
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy

            # 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
            # 새로 queue에 넣어주고 방문 여부를 표시
            if can_go(nx, ny):
                bfs_q.append((nx, ny))
                visited[nx][ny] = True


# 시작점을 모두 bfs queue에 넣음
for _ in range(k):
    x, y = tuple(map(int, input().split()))
    bfs_q.append((x - 1, y - 1))
    visited[x - 1][y - 1] = True

# bfs를 진행
bfs()

ans = sum([
    1
    for i in range(n)
    for j in range(n)
    if visited[i][j]
])

print(ans)
