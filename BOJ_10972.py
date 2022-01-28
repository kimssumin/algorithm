#다음 순열
#brute force

import sys
input = sys.stdin.readline
n = int(input())
s = list(map(int, input().split()))
x = 0
for i in range(n - 1, 0, -1):
    if s[i - 1] < s[i]:
        x = i - 1
        break
for i in range(n - 1, 0, -1):
    if s[x] < s[i]:
        s[x], s[i] = s[i], s[x]
        s = s[:x + 1] + sorted(s[x + 1:])
        print(*s) #이어붙이기
        exit()
print(-1)


#시간초과
'''from itertools import permutations
n = int(input())
input = list(map(int, input().split()))
lst = []
for i in range(n):
    lst.append(i+1)

dic = []
for j in permutations(lst, n):
    dic.append(list(j))

for k in range(len(dic)):
    if dic[k] == input:
        if k == len(dic)-1:
            print(-1)
            break
        else:
            res = dic[k+1]
            for s in res:
                print(s, end = ' ')'''
