#집합
#brute force

import sys

input = sys.stdin.readline

m = int(input())
S = set()

for _ in range(m):
    temp = input().split()
    
    if len(temp) == 1:
        if temp[0] == "all":
            S = set([i for i in range(1, 21)])
        else:
            S = set()
    
    else:
        order, x = temp[0], temp[1]
        x = int(x)

        if order == "add":
            S.add(x)
        elif order == "remove":
            S.discard(x)
        elif order == "check":
            print(1 if x in S else 0)
        elif order == "toggle":
            if x in S:
                S.discard(x)
            else:
                S.add(x)
    
