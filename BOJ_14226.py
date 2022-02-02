#이모티콘
#BFS

from collections import deque

n = int(input())
emo = [[-1 for _ in range(n+1)] for _ in range(n+1)]
res = -1

def bfs(n):
    queue = deque()
    queue.append((1,0))
    emo[1][0] = 0
    while queue:
        s,c = queue.popleft()
        if emo[s][s] == -1:
            emo[s][s] = emo[s][c] + 1
            queue.append((s,s))
        if s+c <= n and emo[s+c][c] == -1:
            emo[s+c][c] = emo[s][c] + 1
            queue.append((s+c, c))
        if s-1 >= 0 and emo[s-c][c] == -1:
            queue.append((s-1, c))
            emo[s-1][c] = emo[s][c] + 1



bfs(n)


for i in range(n+1):
    if emo[n][i] != -1:
        if res == -1 or res > emo[n][i]:
            res = emo[n][i]

print(res)