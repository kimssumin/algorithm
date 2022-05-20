# 선물고르기
#

n = int(input())
value = list(map(int, input().split()))
cost = list(map(int, input().split()))
value.sort()
cost.sort()
stack = []

max = value[0] - cost[0]
max_i = 0
cnt = 0

for i in range(1, len(value)):
    if max < value[i] - cost[i]:
        max = value[i] - cost[i]
        max_i = i
    if max == value[i] - cost[i]:
        cnt += 1

if cnt == len(value) - 1:
    print(value[-1])
else:
    print(value[max_i])
