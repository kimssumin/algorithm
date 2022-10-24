
# 첫번째 시도
from collections import deque

n, k = map(int, input().split())
maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))

r, c = map(int, input().split())
r -= 1
c -= 1
q = deque()


def can_go(x, y, a):
    if 0 <= x and x < n and 0 <= y and y < n:
        if not visited[x][y] and a > maps[x][y]:
            return maps[x][y]
        elif visited[x][y]:
            return False
        else:
            return False
    else:
        return False


def bfs():
    cnt = 0
    while q:
        x, y = q.popleft()
        dxs = [0, 1, 0, -1]
        dys = [1, 0, -1, 0]
        a = maps[x][y]
        candidate = []
        cnt += 1
        for dx, dy in zip(dxs, dys):
            new_dx, new_dy = x + dx, x+dy
            if can_go(new_dx, new_dy, a) != False:
                candidate.append([can_go(new_dx, new_dy, a), new_dx, new_dy])
        if len(candidate) == 0:
            return [x+1, y+1]
        else:
            candidate.sort(key=lambda x: (-x[0], x[1], x[2]))
            new_dx, new_dy = candidate[0][1], candidate[0][2]
            q.append([new_dx, new_dy])
            visited[new_dx][new_dy] = True
        if cnt == k:
            return [new_dx+1, new_dy+1]


q.append([r, c])
visited = [[False for _ in range(n)]for _ in range(n)]
visited[r][c] = True

print(*bfs())
