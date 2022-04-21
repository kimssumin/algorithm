# 비용 합 질의
# n개의 노드에 비용(cost, weight) 주어짐, m 개의 에지
# subtree 함수는 부트리에 포함된 노드의 비용을 모두 더해서 return (자기자신도 포함)
# update 함수는 노드 v 비용을 d만큼 더함

from itertools import count
import sys
input = sys.stdin.readline


n, q = map(int, input().split())
cost = list(map(int, input().split()))
tree = [[] for _ in range(n+2)]
for _ in range(n-1):
    p, c = map(int, input().split())
    tree[p].append(c)


def dfs(idx):  # subtree 노드 갯수 찾는 함수
    global cnt

    # 순회를 할때마다 카운트
    cnt += 1
    # 자식노드를 순회
    for i in tree[idx]:
        dfs(i)


cnt = 0
dfs(n)  # 결과값 호출


def update_fenwick_tree(tree, index, value):
    while index < len(tree):
        tree[index] += value
        index += (index & -index)

    return tree


def query_fenwick_tree(tree, index):
    res = 0
    while index > 0:
        res += tree[index]
        index -= (index & -index)

    return res


for i in range(n):
    tree = update_fenwick_tree(tree, i+1, cost[i])

for _ in range(M + K):
    a, b, c = map(int, input().split())

    if a == 1:
        tree = update_fenwick_tree(tree, b, c - cost[b-1])
        cost[b-1] = c
    elif a == 2:
        print(query_fenwick_tree(tree, c) - query_fenwick_tree(tree, b-1))


for _ in range(q):
    do = str(input())
    v = int(v)
    if do.startswith('sub'):
        v = int(do.split()[1])
        query_fenwick_tree(tree, 1) - query_fenwick_tree()
    else:
        v = int(do.split()[1])
        d = int(do.split()[2])
        update_fenwick_tree(tree, v, d)
        cost[v] = d + cost[v]  # 비용 업데이트
