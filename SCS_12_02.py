# dijkstra algorithm
#다익스트라 알고리즘의 시간복잡도 O(mlogn) (m : 간선의 개수, n : 노드의 개수)

#sol -> 다익스트라를 노드개수만큼 반복해서 돌림 (역으로도 에지 이음)
import sys
import heapq #우선순위 큐 구현을 위하여

n = int(input())
m = int(input())


inf = sys.maxsize
dp = [[inf]*2 for _ in range(n+1)]
graph = [[]for _ in range(n+1)]
heap = []


def dij(start):
    heapq.heappush(heap, [0, start]) #시작노드부터 탐색하기위해
    dp[start][0] = 0
    while heap: #heap에 남아있는 노드가 없으면 끝
        a, b = heapq.heappop(heap) #탐색할 노드와 거리를 가지고옴
        for new_des, wei in graph[b]:
            n_w = wei + a #해당 노드를 거쳐갈때의 거리
            if n_w < dp[new_des][1]: #알고있는 거리보다 작으면 갱신
                dp[new_des][1] = n_w
                dp[new_des].sort()
                heapq.heappush(heap, [n_w, new_des]) #다음 인접 거리를 계산하기 위해 삽입


for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])

sum = 0


dij(0)
#다익스트라 알고리즘의 시간복잡도 O(mlogn) (m : 간선의 개수, n : 노드의 개수)

for i in range(1, n):
    if dp[i][1] == inf: # 경로가 존재하지 않는 경우
        #print(str(i)+"번째 : -1")
        continue
    else:
        sum += (dp[i][1]) # 두번째로 작은 값들의 합
        #print(str(i)+"번째 :" + str(dp[i][1]))
print(sum)
