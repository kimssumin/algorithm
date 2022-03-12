# 목표 구간 합 찾기

# 수행시간 예상 : O(N)

import sys
from itertools import combinations as com

n, k = map(int, input().split())  # n, k 입력
input = sys.stdin.readline
A = list(map(int, input().split()))  # 리스트 A 입력

# 순차형 자료구조
# 투포인터 알고리즘을 이용
start, end = 0, 1  # 시작점과 끝점 (초기값은 index 0, 1로 시작)
sums = A[0]  # 합의 초기값은 A[0]값으로 한다
answer = 0  # answer 판단을 위한 변수

while start <= end and end <= n:  # start 값이 end 값 보다 같거나 작고 end 값이 리스트의 끝 index까지 반복
    # 리스트 슬라이싱 -> 시간복잡도 O(end - start) (슬라이싱되는 요소들 수 만큼 비례)
    sums = sum(A[start:end])
    if sums == k:
        answer = 1  # 목표 값과 같아졌으므로 1을 주고 break
        break
    elif sums < k:  # 목표값보다 합이 작을때엔, 구간을 넓혀야하므로 end 값을 +1한다
        end += 1
    else:
        start += 1  # 목표값보다 합이 클 때엔, 구간을 좁혀야하므로 start 값을 +1한다


if answer == 1:  # answer 값이 최종적으로 1이면
    print(True)  # True
else:
    print(False)


'''시간초과
import sys
from itertools import combinations as com

n, k = map(int, input().split()) #n, k 입력
input = sys.stdin.readline
A = list(map(int, input().split())) #리스트 A 입력

answer = 0


for i in range(0, n): 
	sums = 0 #구간 합을 저장할 변수 지정
	for j in range(i, n):
		sums += A[j]
		if sums == k:
			answer = 1
			break
	if answer == 1:
		break 
		
if answer == 1:
	print(True)
else:
	print(False)
  '''
