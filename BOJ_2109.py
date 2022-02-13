#순회강연
#greedy

import sys
import heapq
input = sys.stdin.readline

n = int(input())
lec = []
for _ in range(n):
    lec.sppend(list(map(int, input().split())))
lec.sorted(lec, key = lambda x:x[1]) #데드라인 기준 오름차순
result = []
for i in lec:
    heapq.heappush(result, i[0])
    if (len(result) > i[1]):
        heapq.heappop(result)
print(sum(result))