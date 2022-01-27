#연속합2
#DP
import sys

n = int(input())
input = sys.stdin.readline

l = list(map(int , input().split()))

dp = [0] * n
dr = [0] * n
dp[0] = l[0]
dr[n-1] = l[n-1]

for i in range(1, len(dp)):
    dp[i] = max(dp[i-1] + l[i] , l[i])

for j in range(n-2, -1, -1):
    dr[j] = max(dr[j+1] + l[j], l[j])

dp2 = [0]*n
for k in range(n):
    if k == 0 or k == n-1:
        dp2[k] = l[k]
        continue
    else :
        dp2[k] = dp[k-1] + dr[k+1]

res = max(max(dp), max(dp2))
print(res)
