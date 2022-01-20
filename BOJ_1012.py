#BFS
#처음에 그래프의 각 칸을 돌다가 1인 칸을 발견하면 BFS를 수행한다. BFS를 수행하면 1인 칸은 0으로 변경하게 되므로 한 구역의 BFS가 모두 끝나면 그 구역은 1이 모두 0으로 바뀐다. 
#즉, 1인 칸 하나를 발견하여 그 칸에서 BFS를 수행하면 그 구역의 1은 모두 0으로 바뀌므로 1인 칸을 발견할 때 마다 카운트 +1 을 하고 BFS를 수행하면 정답을 구할 수 있다.

from collections import deque

dx = [0,0,1,-1]
dy = [1,-1,0,0]

t = int(input())

def bfs(graph, a, b):
    queue = deque()
    queue.append((a,b))
    graph[a][b] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx < 0 or nx >=n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
    return

for i in range(t):
    cnt = 0
    n, m, k = map(int,input().split())
    graph = [[0]*m for _ in range(n)]

    for j in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1

    for a in range(n):
        for b in range(m):
            if graph[a][b] == 1:
                bfs(graph, a, b)
                cnt += 1
    print(cnt)