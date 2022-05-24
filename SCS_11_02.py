# 선물고르기
#O(nlogn)의 시간복잡도

n = int(input())
value = list(map(int, input().split()))
cost = list(map(int, input().split()))
value.sort()  # O(nlogn)
cost.sort()  # O(nlogn)
stack = []

maxs = value[0] - cost[0]  # 초기값 : index 0 의 가치와 가격표의 차이
max_i = 0  # 그때의 index
cnt = 0

for i in range(1, len(value)):  # O(n)
    if maxs < value[i] - cost[i]:
        maxs = value[i] - cost[i]  # 가치와 가격표의 차이의 최댓값을 찾는다
        max_i = i  # 그때의 i 값도 저장함
    if maxs == value[i] - cost[i]:
        cnt += 1

if cnt == len(value) - 1:  # 최대차이가 최소가 되도록 선택할 상품이 여러개인 경우
  print(value[-1])
else:
  print(value[max_i])
