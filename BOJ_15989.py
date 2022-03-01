#1,2,3 더하기 4
#DP

import sys

input = sys.stdin.readline

T = int(input())

dp = [1] * 10001 #1만 써서 합되는 경우

for i in range(2, 10001):
    dp[i] += dp[i - 2] #2가 추가되는 경우
    
for i in range(3, 10001):
    dp[i] += dp[i - 3] #3이 추가되는 경우


for _ in range(T):
    n = int(input())
    print(dp[n])