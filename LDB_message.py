#전보
#우선순위 큐를 이용한 다익스트라 알고리즘 ()

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

n, m , c = map(int, input().split())
graph = [[]for i in range(n+1)]
distance = [INF] * (n+1)

for _ in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))

def dijkstra(c):
    q = []
    heapq.heappush(q, (0, c))
    distance[c] == 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]: #현재노드와 연결된 다른 인접노드들을 확인
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] == cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(c)

count = 0 #도달할 수 있는 노드의 개수
max_distance = 0
for d in distance:
    if d != INF:
        count += 1
        max_distance = max(max_distance, d)

print(count-1, max_distance) #시작노드는 제외해야하여 count - 1 을 출력
 