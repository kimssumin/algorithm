#퇴사
#brute force- 재귀

import sys

n = int(input())
p_list = []
t_list = []
res = []
for _ in range(n):
    t, p = map(int, sys.stdin.readline().split())
    t_list.append(t)
    p_list.append(p)
    res.append(p)
res.append(0)

for i in range(n-1, -1, -1):
    if (i + t_list[i]) > n:
        res[i] = res[i+1]
    else:
        res[i] = max(res[i+1] , p_list[i] + res[i + t_list[i]])
print(res[0])

