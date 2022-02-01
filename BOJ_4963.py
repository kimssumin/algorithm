#섬의 개수
#graph 
#dfs

import sys
sys.setrecursionlimit(10000)

dx = [-1, 0, 1, -1, 1, -1, 0, 1]
dy = [1, 1, 1, 0, 0, -1, -1, -1]

def dfs (x, y):
    if x <= -1 or x >= h or y >= w or y <= -1:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        for i in range(8):
            dfs(x + dx[i] , y + dy[i])
        return True
    return False

while(1):
    result = 0
    w, h = map(int, input().split())
    if w ==0 and h == 0:
        break
    
    graph = []
    for _ in range(h):
        graph.append(list(map(int, input().split())))
    for i in range(h):
        for j in range(w):
            if dfs(i, j) == True:
                result += 1
    print (result)
        