#dfs 스페셜 저지
#dfs
#graph


#틀린풀이 -> WHY?
import sys
sys.setrecursionlimit(100000)

n = int(input())
arr = [[] for _ in range(n+1)]
visited = [False] * (n+1)
ans = []

for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    arr[a].append(b)
    arr[b].append(a)
compare = list(map(int, sys.stdin.readline().split()))

def dfs(graph, v, visited):
    visited[v] = True
    ans.append(v)
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

for j in range(1, n+1):
    if not visited[j]:
        dfs(arr, j, visited)

if ans == compare:
    print(1)
else:
    #print(ans)
    print(0)