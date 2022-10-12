import heapq
n = int(input())
pq = list(map(int, input().split()))
num = []

for nn in pq:
    heapq.heappush(num, -nn)

while(len(num) >= 2):
    max1 = -heapq.heappop(num)
    max2 = -heapq.heappop(num)
    if max1 != max2:
        heapq.heappush(num, -max1+max2)


if (len(num)) == 0:
    print(-1)
else:
    print(-heapq.heappop(num))
