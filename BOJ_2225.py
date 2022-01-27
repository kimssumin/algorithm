# #합분해
# #DP

n, k = map(int,input().split())
dp = [[0] * (k+1) for _ in range(n+1)]
dp[0][0] = 1
for i in range(0, n+1):
    for j in range(1, k+1):
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
print(dp[n][k] % 1000000000)


# 아래는 메모리 초과된 ... code...
# import itertools

# n, k = map(int, input().split())

# nums = [0] * (k+n-1)
# data = list(itertools.combinations(nums, n))
# print(len(data))

