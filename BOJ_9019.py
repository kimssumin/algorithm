#DSLR
#bfs

#pypy3로 채점 , 파이썬은 시간초과
import sys
from collections import deque

input = sys.stdin.readline

T = int(input())

def bfs(x):
    q = deque()
    q.append([x, ''])
    check[x] = 1
    while q:
        x, result = q.popleft()
        if x == B:
            return result
        if 2 * x <= 9999 and check[2*x] == 0:
            check[2*x] = 1
            q.append([2*x, result + 'D'])
        if 2 * x > 9999 and check[((2 * x) % 10000)] == 0:
            check[(2 * x) % 10000] = 1
            q.append([(2 * x) % 10000, result + 'D'])
        if x-1 >= 0 and check[x-1] ==0:
            check[x-1] = 1
            q.append([x-1, result+'S'])
        if x-1 < 0 and check[9999] == 0:
            check[9999] = 1
            q.append([9999, result +'S'])
        nx = int((x % 1000) * 10 + x / 1000)
        if check[nx] == 0:
            check[nx] = 1
            q.append([nx, result + 'L'])
        nx = int((x%10)*1000 + x/10)
        if check[nx] == 0:
            check[nx] = 1
            q.append([nx, result + 'R'])


for _ in range(T):
    A, B = map(int, input().split())
    check = [0 for _ in range(10000)]
    print(bfs(A))



