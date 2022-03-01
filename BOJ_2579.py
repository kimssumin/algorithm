#계단오르기
#dp

import sys

n = int(input())
input = sys.stdin.readline
st = []
dp = []

for _ in range(n):
    st.append(int(input()))

dp.append(st[0])
dp.append(max(st[0] + st[1], st[1]))
dp.append(max(st[0] + st[2], st[1] + st[2]))

for i in range(3, n):
    dp.append(max(dp[i-2] + dp[i], dp[i-3] + dp[i] + dp[i-1]))

print(dp.pop())