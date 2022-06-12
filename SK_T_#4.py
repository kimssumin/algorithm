# BOJ 16930 유사

from collections import deque


def solution(grid, k):
    answer = -1
    pann = []
    for i in grid:
        pann.append(list(i))
        m = len(list(i))
        n = len(grid)
    dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
    vis = [[-1] * m for _ in range(n)]
    x1, y1 = 1, 1
    x2, y2 = n, m

    q = deque()
    q.append((x1-1, y1-1))
    vis[x1-1][y1-1] = 0
    while q:
        y, x = q.popleft()
        if y == x2-1 and x == y2-1:
            print(vis[y][x])
            answer = vis[y][x] - 1
        for i in range(4):
            for num in range(1, k+1):
                xx = x + dx[i] * num
                yy = y + dy[i] * num
                if xx < 0 or xx >= m or yy < 0 or yy >= n:
                    break
                if pann[yy][xx] == '#':
                    break
                if pann[yy][xx] == 'F' and num == k:
                    break
                if vis[yy][xx] == -1:
                    q.append((yy, xx))
                    vis[yy][xx] = vis[y][x] + 1
                elif vis[yy][xx] == vis[y][x] + 1:
                    continue
                else:
                    break
    return answer
