# DP 이용
#시간복잡도 : O(nlogn) + O(qlogn)

import sys
import math
from collections import deque  # deque 이용

n, q = map(int, sys.stdin.readline().split())
# log2를 취해서 2^k 번쨰 조상을 최대 몇번 갈수있는지 -> 최악의 경우에도 루트노드로 갈수있음
logn = int(math.log2(n)) + 1
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    p, c = map(int, sys.stdin.readline().split())
    graph[p].append(c)
    graph[c].append(p)

depth = [-1]*(n+1)

# 2^k번째 부모노드 저장
parent = [[0]*logn for _ in range(n+1)]
queue = deque([1])
depth[1] = 0
while queue:  # O(N)
    v = queue.popleft()
    for w in graph[v]:
        if depth[w] == -1:
            depth[w] = depth[v]+1  # depth[w] = w의 깊이, =부모노드깊이 + 1
            parent[w][0] = v  # parent의 가장 높은 조상은 부모노드
            queue.append(w)

# O(nlogn)
for j in range(logn-1):
    for i in range(1, n+1):
        # parent[i][j] 는 i의 2^j번째 조상이다
        parent[i][j+1] = parent[parent[i][j]][j]
        # i의 2^(j+1) 번째 조상은 parent[i][j] 의 2^j 번째 조상의 2^j번째 조상과 같다
        # j = 2 -> i의 8번째 조상은 parent[i][j]의 4번쨰 조상과 같다

# O(Qlogn)
for _ in range(q):  # 질의
    u, v = map(int, sys.stdin.readline().split())
    if depth[u] < depth[v]:
        u, v = v, u  # swap
    # u의 조상찾기
    for i in range(logn-1, -1, -1):  # logn-1부터 시작하여 모든 조상을 체크할수있음
        if depth[u] - depth[v] >= 1 << i:  # 두 차이를 구하여 레벨을 맞춤
            u = parent[u][i]
    if u != v:  # u와 v가 다르다면 현재 깊이가 같은 상태이므로 깊이를 증가시키면서 조상이 같아질때까지 반복한다
        for j in range(logn-1, -1, -1):  # logn을 사용해 내림
            if parent[u][j] != 0 and parent[u][j] != parent[v][j]:  # 처음으로 달랐던 부분으로 가서 다시 검색
                u, v = parent[u][j], parent[v][j]
        u = parent[u][0]
    # 서로 같은 조상이 나오기 바로 전까지 반복 후 u,v 둘 중 하나의 노드의 조상이 lca 가 되돍
    print(u)

# 일반적인 dfs 코드
# import sys
# input = sys.stdin.readline
# sys.setrecursionlimit(10**5)
# max_depth = 20

# N = int(input())
# tree = [[] for _ in range(N + 1)]
# for _ in range(N-1):
#     a, b = map(int, input().split())
#     tree[a].append(b)
#     tree[b].append(a)

# depth = [-1] * (N+1)
# ancestor = [[0] * (max_depth+1) for _ in range(N+1)]
# depth[1] = 0


# def storeancestor(parent, son):
#     ancestor[son][0] = parent
#     for i in range(1, max_depth):
#         temp = ancestor[son][i - 1]
#         ancestor[son][i] = ancestor[temp][i-1]


# def dfs(parent):
#     for son in tree[parent]:
#         if depth[son] == -1:
#             depth[son] = depth[parent] + 1
#             storeancestor(parent, son)
#             dfs(son)


# dfs(1)

# ## left depth <= right depth


# def makeSameDepth(left, right):
#     if depth[left] == depth[right]:
#         return left, right

#     for tmp in ancestor[right]:
#         if depth[tmp] >= depth[left]:
#             temp = tmp
#         else:
#             break
#     return makeSameDepth(left, temp)


# def findSameAncestor(left, right):
#     if left == right:
#         return left

#     elif ancestor[left][0] == ancestor[right][0]:
#         return ancestor[left][0]

#     for i in range(1, max_depth+1):
#         if ancestor[left][i] == ancestor[right][i]:
#             LEFT = ancestor[left][i-1]
#             RIGHT = ancestor[right][i-1]
#             return findSameAncestor(LEFT, RIGHT)


# M = int(input())
# for _ in range(M):
#     a, b = map(int, input().split())

#     if depth[a] < depth[b]:
#         a, b = makeSameDepth(a, b)

#     elif depth[a] > depth[b]:
#         b, a = makeSameDepth(b, a)

#     ans = findSameAncestor(a, b)
#     print(ans)
