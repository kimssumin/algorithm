#DP
#포도주 시식

import sys

n = int(input())
input = sys.stdin.readline
w = []
for i in range(n):
    w.append(int(input()))
#print(w[0])
dp = [0]*(n+1)
#print(dp)
dp[0] = 0
dp[1] = w[0]
if n >=2 :
    dp[2] = w[0] + w[1]
    if n>=3:
        dp[3] = max(dp[2], w[0]+w[2], w[1]+w[2])
        for j in range(4, n+1):
            dp[j] = max(dp[j-1], dp[j-3]+w[j-1]+w[j-2], dp[j-2]+w[j-1])
print (dp[n])
    
