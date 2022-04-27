# 비용 합 질의

# n개의 노드에 비용(cost, weight) 주어짐, m 개의 에지
# subtree 함수는 부트리에 포함된 노드의 비용을 모두 더해서 return (자기자신도 포함)
# update 함수는 노드 v 비용을 d만큼 더함

from ipaddress import v6_int_to_packed
from itertools import count
from re import I
import sys
input = sys.stdin.readline


n, q = map(int, input().split())
cost_init = list(map(int, input().split()))
cnts_init = []
tree = [[] for _ in range(n+2)]
for _ in range(n-1):
    p, c = map(int, input().split())
    tree[p].append(c)

visited = [0] * (n+1)
preorder = [1]
cost = [cost_init[0]]


def counts(x):
    global cnt
    for i in tree[x]:
        cnt += 1
        if tree[i]:
            counts(i)
    return cnt + 1


for i in range(1, n+1):
    cnt = 0
    cnts_init.append(counts(i))


cnts = [cnts_init[0]]


def dfs(x, l):
    visited[x] = True
    for i in tree[x]:
        if not visited[i]:
            #parent[i] = x
            preorder.append(i)
            cost.append(cost_init[i-1])  # cost 작성 (preorder 순으로)
            cnts.append(cnts_init[i-1])  # 자식노드 갯수 count
            dfs(i, l+1)


dfs(1, 0)  # preorder list 작성
print(preorder)
print(cost)
print(cnts)


def LSB(k):
    return k & -k


T_cost = []
for a in range(len(cost)):
    if a % 2 == 0:
        T_cost.append(cost[a])
    else:
        cc = 0
        for k in range(a, a - LSB(a+1), -1):
            cc += cost[k]
        T_cost.append(cc)
print(T_cost)


def prefix_sum(k):
    s = 0
    while k >= 1:
        s += T_cost[k-1]
        k = k - LSB(k)
    return s


# print(prefix_sum(7))  # cost[6]까지의 합


def update(k, x):  # T_cost[k]를 x+T_cost[k]로 change
    while k <= n:  # (O(logN))
        T_cost[k] = T_cost[k] + x
        k = k + LSB(k+1)  # O(1)


for _ in range(q):  # 질의
    do = str(input())
    #v = int(v)
    if do.startswith('sub'):  # subtree
        v = int(do.split()[1])
        if v == 1:
            result_sub = prefix_sum(n)
            print(result_sub)
        else:
            i = preorder.index(v)
            result_sub = prefix_sum(i + cnts[i]) - prefix_sum(i)
            print(result_sub)
    else:
        v = int(do.split()[1])
        d = int(do.split()[2])
        i = preorder.index(v)
        update(i, d)
        cost[i] = d + cost[i]  # 비용 업데이트


# def update_fenwick_tree(tree, index, value):
#     while index < len(tree):
#         tree[index] += value
#         index += (index & -index)
#     return tree


# def query_fenwick_tree(tree, index):
#     res = 0
#     while index > 0:
#         res += tree[index]
#         index -= (index & -index)

#     return res


# for i in range(n):
#     tree = update_fenwick_tree(tree, i+1, cost[i])

# for _ in range(M + K):
#     a, b, c = map(int, input().split())

#     if a == 1:
#         tree = update_fenwick_tree(tree, b, c - cost[b-1])
#         cost[b-1] = c
#     elif a == 2:
#         print(query_fenwick_tree(tree, c) - query_fenwick_tree(tree, b-1))
