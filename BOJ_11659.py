import sys
N, M = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))
sum = 0
lists = []

for i in range(0, N):
  sum = sum + num[i]
  lists.append(sum)
  
for i in range (0, M):
  i, j = map(int, sys.stdin.readline().split())
  if i >= 2:
    print(lists[j-1] - lists[i-2])
  else :
    print(lists[j-1])
  