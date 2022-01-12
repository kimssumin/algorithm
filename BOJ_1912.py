#연속합
#DP

n = int(input())
li = list(map(int, input().split()))
d = [0] * len(li)
result = -10000

for i in range(n):
    d[i] = max(d[i-1] + li[i], li[i])
    result = max(result, d[i])

print(result)