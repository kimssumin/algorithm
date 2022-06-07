# 최선과 차선

# 2번째 차선책의 합
# dijkstra algorithm

import sys
import heapq

n = int(input())
m = int(input())


inf = sys.maxsize
dp = [[inf]*2 for _ in range(n+1)]
graph = [[]for _ in range(n+1)]
heap = []


def dij_2nd(start):
    heapq.heappush(heap, [0, start])
    dp[start][0] = 0
    while heap:
        a, b = heapq.heappop(heap)
        for n_n, wei in graph[b]:
            n_w = wei+a
            if n_w < dp[n_n][1]:
                dp[n_n][1] = n_w
                dp[n_n].sort()
                heapq.heappush(heap, [n_w, n_n])


for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])

sum = 0

dij_2nd(0)
# dij_1st(0)
# print(dp)

for i in range(1, n):
    if dp[i][1] == inf:
        #print(str(i)+"번째 : -1")
        continue

    else:
        sum += (dp[i][1])
        #print(str(i)+"번째 :" + str(dp[i][1]))

print(sum)
