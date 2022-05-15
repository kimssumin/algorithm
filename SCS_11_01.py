#땅따먹기
#

n, k = map(int, input().split())
ground = []
dp = [[0] * n for _ in range(n)]
for i in range(n):
    ground.append(list(map(int, input().split())))
    if n >= 3:
        dp[i][0] = ground[i][0]
        dp[i][1] = ground[i][0] + ground[i][1]
        dp[i][2] = ground[i][0] + ground[i][1] + ground[i][2]

if k > (n // 3) * n:
    print(-1)
else:
    for i in range(n):
        for j in range(3, n):
            dp[i][j] = max(dp[i][j-1])
