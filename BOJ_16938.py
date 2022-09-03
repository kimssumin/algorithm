# 캠프준비
# bruteforce
from itertools import combinations

n, l, r, x = map(int, input().split())
level = list(map(int, input().rstrip().split()))


ans = 0
for i in range(2, n + 1):
    for com in combinations(level, i):
        if l <= sum(com) <= r:
            if max(com) - min(com) >= x:
                ans += 1

print(ans)


# two pointer algorithm 사용 실패
# level.sort()

# end = 1
# cnt = 0
# sum = 0

# for start in range(0, n-1):
#     sum += level[start]
#     while (end < n) and (sum <= r):
#         print(start, end)
#         sum += level[end]

#         if (l <= sum <= r) and (level[end] - level[start] >= x):
#             cnt += 1
#             print(start, end, 'success')
#         end += 1
#         sum -= level[start]
# print(cnt)
