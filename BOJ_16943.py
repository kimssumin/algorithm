# 숫자 재배치
# bruteforce

from itertools import permutations as per

a, b = (input().split())
check = False
ans = 0

if len(a) > len(b):
    print(-1)
else:
    for j in list(per(a, len(a))):
        if (int("".join(j)) <= int(b)) and (int(j[0]) != 0):
            ans = max(ans, int("".join(j)))
            check = True
    if (check == False):
        print(-1)
    else:
        print(ans)
