#숨바꼭질 3
#BFS

from collections import deque

n, k = map(int, input().split())
MAX = 10 ** 5     # 시간초과 안나게 수 제한
dist = [0] * (MAX + 1) 
check = [False] * (MAX + 1) 

def bfs(n):
    queue = deque()
    queue.append(n)
    check[n] = True
    while queue:
        x = queue.popleft()
        if x == k:
            print(dist[x])
            return
        if x * 2 <= MAX and check[x*2] == False :
            queue.appendleft(x*2)
            check[x*2] = True
            dist[x*2] = dist[x]
        if x + 1 <= MAX and check[x+1] == False:
            queue.append(x+1)
            check[x+1] = True
            dist[x +1] = dist[x] + 1
        if x - 1 >= 0 and check[x-1] == False:
            queue.append(x-1)
            check[x-1] = True
            dist[x-1] = dist[x] + 1
bfs(n)