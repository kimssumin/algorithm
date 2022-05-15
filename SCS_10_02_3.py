# 정답코드

def solve(a, b, t):
    dp = [0] * (t+1)

    for i in range(1, t+1):
        first, second = -1, -1
        if i >= a:
            first = dp[i-a]
        if i >= b:
            second = dp[i-b]
        if first == -1 and second == -1:
            dp[i] = -1
        else:
            dp[i] = max(first, second) + 1
    if dp[t] >= 0:
        print(dp[t])
        return
    i = t-1
    c = dp[i]
    while c == -1:
        i -= 1
        c = dp[i]
    print(c, t-i)
