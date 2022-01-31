#이분그래프
#graph
#dfs

import sys
sys.setrecursionlimit(100000)

K = int(input())

input = sys.stdin.readline

def dfs(v, group):
    visited[v] = group
    for i in arr[v]:
        if visited[i] == 0:
            if not dfs(i, -group):
                return False
        elif visited[i] == visited[v]:
            return False
    return True


for _ in range(K):
    V, E = map(int, input().split())
    arr = [[] for _ in range(V+1)]
    visited = [0] * (V+1)

    for _ in range(E):
        u, v = map(int, input().split())
        arr[u].append(v)
        arr[v].append(u)

    two = True

    for i in range(1, V+1):
        if visited[i] == 0:
            two = dfs(i, 1)
            if not two:
                break
    print('YES' if two else 'NO')

