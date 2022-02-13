#보석도둑
#greedy

import sys
import heapq

n, k = map(int, input().split())
input = sys.stdin.readline
gem = []
c = []
for _ in range(n):
    gem.append(list(map(int, input().split())))
gem.sort()

for _ in range(k):
    c.append(int(input()))
c.sort()

result = 0
temp = [] #현재 gem의 무게보다 작은 보석들

for i in c:
    while gem and c >= gem[0][0]:
        heapq.heappush(temp, -gem[0][1]) #max heap
        #무게를 제외한 값만 heappush 하여 넣어줌 (최대힙)
        heapq.heappop(gem)
    if temp:
        result += heapq.heappop(temp)
    elif not gem:
        break

print(-result)

