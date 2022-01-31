#graph
#dfs
#ABCDE 간선

n, m = map(int, input().split())
import sys
input = sys.stdin.readline
fri = [[] for i in range(n)]
visited = [False] * n

for _ in range (m):
    a, b =map(int, input().split())
    fri[a].append(b)
    fri[b].append(a)
    
def dfs(idx, number):
    if number == 4:
        print(1)
        exit()
    for i in fri[idx]:
        if not visited[i]:
            visited[i] = True
        dfs(i, number+1)
        visited[i] = False

for i in range(n):
    visited[i] = True
    dfs(i,0)
    visited[i] = False

print(0)