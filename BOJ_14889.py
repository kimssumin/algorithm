#스타트와 링크
#brute force - 재귀

from itertools import combinations as com

n = int(input())
member = [i for i in range(n)]
ability = []
for _ in range(n):
    ability.append((list(map(int, input().split()))))
result = int(1e9)
for r1 in com(member, n//2):
    start, link = 0, 0
    r2 = list(set(member) - set(r1))
    for r in com(r1, 2): #Sij Sji
        start += ability[r[0]][r[1]]
        start += ability[r[1]][r[0]]
    for r in com(r2, 2):
        link += ability[r[0]][r[1]]
        link += ability[r[1]][r[0]]
    result = min(result, abs(start-link))
print(result)