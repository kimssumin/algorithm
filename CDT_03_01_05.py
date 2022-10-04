# 뿌요뿌요
# dfs

n = int(input())
pann = []
for _ in range(n):
    pann.append(list(map(int, input().split())))

visited = [
    [False for _ in range(n)]
    for _ in range(n)
]


def in_range(x, y):
    return 0 <= x and x < n and 0 <= y and y < n


def can_go(x, y, k):
    if not in_range(x, y):
        return False

    if visited[x][y] or pann[x][y] != k:
        return False

    return True


def dfs(x, y, k):
    global cnt
    # 0: 위쪽, 1: 오른쪽, 2: 아래쪽, 3: 왼쪽
    dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]

    # 네 방향에 각각에 대하여 DFS 탐색을 합니다.
    for dx, dy in zip(dxs, dys):
        new_x, new_y = x + dx, y + dy

        if can_go(new_x, new_y, k):
            visited[new_x][new_y] = True
            cnt += 1
            dfs(new_x, new_y, k)


block_list = []

for i in range(n):
    for j in range(n):
        k = pann[i][j]
        if can_go(i, j, k):
            visited[i][j] = True
            cnt = 1

            dfs(i, j, k)
            block_list.append(cnt)

num = 0
max_block = 0

for b in block_list:
    max_block = max(b, max_block)
    if b >= 4:

        num += 1

print(num, max_block)
