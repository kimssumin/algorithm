#K번째 수
# binary search

import sys
n = int(input())
k = int(input())

start, end = 1, k

while start <= end:
    mid = (start + end) // 2
    
    temp = 0
    for i in range(1, n+1):
        temp += min(mid//i, n) #mid 이하의 i의 배수 or 최대 N
    
    if temp >= k: #이분탐색 실행
        answer = mid
        end = mid - 1
    else:
        start = mid + 1
print(answer)