#계단오르기
#dp

import sys

n = int(input())
input = sys.stdin.readline
st = []
dp = []

for _ in range(n):
    st.append(int(input()))

if n == 1:
    dp.append(st[0])
elif n == 2:
    dp.append(st[0])
    dp.append(max(st[0] + st[1], st[1]))
elif n == 3 :
    dp.append(st[0])
    dp.append(max(st[0] + st[1], st[1]))
    dp.append(max(st[0] + st[2], st[1] + st[2]))

if n >= 4:
    dp.append(st[0])
    dp.append(max(st[0] + st[1], st[1]))
    dp.append(max(st[0] + st[2], st[1] + st[2]))
    for i in range(3, n):
        dp.append(max(dp[i-2] + st[i], dp[i-3] + st[i] +st[i-1]))

print(dp.pop())