#graph
#Two dots
# dfs

import sys

N, M = map(int, input().split())
dot = [[p for p in sys.stdin.readline().strip()] for _ in range(N)]
visited =[[0] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1] #상하좌우

def dfs(x,y):
    global answer
    visited[x][y] = 1
    for d in range(4):
        X = x+dx[d]
        Y = y+dy[d]
        if 0 <= X < N and 0 <= Y < M: #dot 안에서만 움직인다
            if dot[X][Y] == dot[x][y]: #color same
                if visited[X][Y] == 0 : #방문도 X
                    cycle.append([X, Y])
                    dfs(X, Y)
                    cycle.pop() #방문순서에서 제외
                else:
                    if X == cycle[-2][0] and Y == cycle[-2][1]: #바로전에 방문한 곳
                        pass
                    else: #언젠가 방문한 적 있으면
                        answer = 'Yes'
                        return
        if answer == 'Yes':
            return

answer = 'No'
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0:
            cycle =[[i,j]]
            dfs(i, j)
        if answer == 'Yes':
            break
    if answer == 'Yes':
        break

print(answer)