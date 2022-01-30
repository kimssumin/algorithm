#링크와 스타트
#brute force


#시간초과 - Why!

from itertools import combinations as com
import sys
input = sys.stdin.readline

n = int(input())
#member = [i for i in range(n)]
ability = []
for _ in range(n):
    ability.append((list(map(int, input().split()))))

real_res = int(1e9)

for i in range(1, int((n/2)+ 1)):
    member_divide = com(range(n), i)
    result = int(1e9)
    for r1 in member_divide:
        r1 = list(r1)
        start, link = 0, 0
        r2 = list(set(range(n)) - set(r1))
        for j in range(n-1):
            for k in range(n-1):
                try:
                    start += ability[r1[j]][r1[k]]
                except IndexError:
                    start += 0
                try: 
                    link += ability[r2[j]][r2[k]]
                except IndexError:
                    link += 0
        sub = abs(start - link)
        result = min(result, sub)
    real_res = min(result, real_res)
print(real_res)
