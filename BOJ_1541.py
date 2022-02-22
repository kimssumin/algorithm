#잃어버린 괄호
#greedy


import sys

input = sys.stdin.readline 

cal = input().split('-')
num = []
for i in cal:
    cnt = 0
    plus = i.split('+')
    for j in plus:
        cnt += int(j)
    num.append(cnt)
n = num[0]
for i in range(1, len(num)):
    n -= num[i]

print(n)