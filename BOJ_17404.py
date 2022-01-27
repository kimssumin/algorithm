#DP
#RGB 거리 2

import sys

n = int(input())
li = []
for _ in range(n):
    li.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * 3 for _ in range(2)]
inf = 10000000
res = inf

for j in range(3): #RGB 각각 시작하는 경우
    dp[0][0], dp[0][1], dp[0][2] = inf, inf, inf
    dp[0][j] = li[0][j]

    for i in range(1, n): #두번째 집부터 다음 집과 다른 색으로
        dp[1][0] = min(dp[0][1], dp[0][2]) + li[i][0]
        dp[1][1] = min(dp[0][0], dp[0][2]) + li[i][1]
        dp[1][2] = min(dp[0][0], dp[0][1]) + li[i][2]
        dp[0][0], dp[0][1], dp[0][2] = dp[1][0], dp[1][1], dp[1][2]

    res = min(res, min(dp[0][(j+1)%3], dp[0][(j+2)%3])) #첫번째 집과 마지막 집의 색이 같은 경우만 빼고

print(res)