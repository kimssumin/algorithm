#숨바꼭질4
#BFS
#graph

from collections import deque

def bfs():
    q = deque()             
    q.append(n)             
    while  q:
        x = q.popleft()     
        if x == k:
            print(dist[x])
            result = []
            while x != n:
                result.append(x)
                x = route[x]
            result.append(n)
            result.reverse() #역순 저장 -> 순서 바꿈
            print(' '.join(map(str, result)))
            return
        for nx in (x - 1, x + 1, x * 2):    
            if 0 <= nx <= MAX and not dist[nx]:
                dist[nx] = dist[x] + 1
                q.append(nx)
                route[nx] = x

MAX = 10 ** 5               # 시간초과 안나게 수 제한
dist = [0] * (MAX + 1)      # 이동거리

n, k = map(int, input().split())
route = [0] * (MAX + 1)

bfs()