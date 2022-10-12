
# 앞에서부터 삭제하기2

import heapq

n = int(input())
num_list = list(map(int, input().split()))
avg = 0
pq = []
sum_val = 0

heapq.heappush(pq, num_list[n - 1])
sum_val += num_list[n - 1]

for i in range(n-2, 0, -1):
    heapq.heappush(pq, num_list[i])
    sum_val += num_list[i]

    minus = pq[0]
    avg = max(avg, (sum_val - minus) / (n-i-1))


print(format(avg, ".2f"))
