#가장 긴 감소하는 부분
#DP

n = int(input())
A = list(map(int, input().split()))
dp = [1]*1001

for i in range(n):
    for j in range(i):
        if A[j] > A[i]:
            dp[i] = max(dp[i],dp[j]+1)
print(max(dp))
