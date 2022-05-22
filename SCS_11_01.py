# 땅따먹기

# 이익많게
# dp

n, k = map(int, input().split())
ground = []
dp = [[0] * n for _ in range(n)]
sums = []
stack = []
for i in range(n):
    ground.append(list(map(int, input().split())))
    dp[i][0] = ground[i][0]
    stack[i]

if k > (n // 3) * n:
    print(-1)
else:
    for i in range(n):
        for j in range(1, n):
            dp[i][j] = dp[i][j-1] + ground[j]
    for i in range(n):
        for j in range(2, n):
            if j == 2:
                stack.append(dp[i][j])
            else:
                if stack[-1] < dp[i][j] - dp[i][j-3]:  # <= 해도되나/-?
                    stack.append(dp[i][j] - dp[i][j-3])
