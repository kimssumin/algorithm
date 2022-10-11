import heapq

n, m = map(int, input().split())
lists = list(map(int, input().split()))

pq = []

for elem in lists:
    heapq.heappush(pq, -elem)

# m번에 걸쳐서
# 최댓값을 찾아 1씩 빼주는 것을 반복합니다.
for _ in range(m):
    max_val = -heapq.heappop(pq)
    heapq.heappush(pq, -(max_val - 1))

print(-heapq.heappop(pq))
