# 비용 합 질의

# n개의 노드에 비용(cost, weight) 주어짐, m 개의 에지
# subtree 함수는 부트리에 포함된 노드의 비용을 모두 더해서 return (자기자신도 포함)
# update 함수는 노드 v 비용을 d만큼 더함


# 시간복잡도 :최악의 경우에도 O(n^2/2)보단 적은 시간복잡도
# fenwick tree, dfs 사용
import sys
input = sys.stdin.readline


n, q = map(int, input().split())
# 초기 cost 입력 -> 추후에 preorder 순으로 재배열됨
cost_init = list(map(int, input().split()))
cnts_init = []  # 자식노드 수를 count 할 리스트 -> 이 또한 추후에 preorder 순으로 재배열됨
tree = [[] for _ in range(n+2)]
for _ in range(n-1):
    p, c = map(int, input().split())
    tree[p].append(c)

visited = [0] * (n+1)  # 방문확인용
preorder = [1]  # preorder 순으로 재배열될 tree 리스트, 루트노드는 1

# preorder 순으로 재배열될 cost_init 리스트, 모든 경우 젤 높은 루트노드는 1이므로 1일때의 cost를 먼저 넣어둠
cost = [cost_init[0]]


def counts(x):  # 자식노드 수를 count 할 수 있는 함수
    global cnt
    for i in tree[x]:  # 시간복잡도 : O(tree[x]의 자식노드 수) -> 젤 최악의 경우에도 O(n)
        cnt += 1
        if tree[i]:
            counts(i)
    return cnt + 1  # +1 해주는 이유는 자기자신도 조상이기 때문


# 최악의 경우에도 O(n^2/2)보단 적은 시간복잡도
for i in range(1, n+1):  # 자식노드 카운트 하는 반복문
    cnt = 0
    cnts_init.append(counts(i))  # 최악의 경우 O(n)


cnts = [cnts_init[0]]  # 자식노드 순을 preorder tree 순으로 재배열


def dfs(x, l):  # preorder list 함수
    visited[x] = True
    for i in tree[x]:  # 시간복잡도 : O(tree[x]의 자식노드 수) -> 젤 최악의 경우에도 O(n)
        if not visited[i]:
            #parent[i] = x
            preorder.append(i)
            cost.append(cost_init[i-1])  # cost 작성 (preorder 순으로)
            cnts.append(cnts_init[i-1])  # 자식노드 갯수 count (preorder 순으로)
            dfs(i, l+1)


dfs(1, 0)  # preorder list 작성
# print(preorder)
# print(cost)
# print(cnts)


def LSB(k):  # k의 오른쪽에서 첫번째 1의 비트 위치가 d 번째라면 2^d return
    return k & -k


T_cost = []  # BIT 트리 작성
for a in range(len(cost)):
    if a % 2 == 0:  # index number 기준 짝수일때 (bit tree 기준 홀수일때)
        T_cost.append(cost[a])  # 자기 자신 하나만 저장
    else:
        cc = 0
        for k in range(a, a - LSB(a+1), -1):  # O(LSB(a+1))만큼의 시간복잡도
            cc += cost[k]
        T_cost.append(cc)
# print(T_cost)


def prefix_sum(k):  # prefix_sum 의 수행시간은 O(logN)
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


# 시간복잡도 O(q * n)
for _ in range(q):  # 질의
    do = str(input())
    #v = int(v)
    if do.startswith('sub'):  # subtree 질의가 들어온다면
        v = int(do.split()[1])
        if v == 1:  # 1인 경우 전체 노드의 합을 구하는 것이므로
            result_sub = prefix_sum(n)  # O(logN)
            print(result_sub)
        else:
            i = preorder.index(v)  # O(N)의 시간복잡도
            result_sub = prefix_sum(i + cnts[i]) - prefix_sum(i)  # O(logN)
            print(result_sub)
    else:
        v = int(do.split()[1])
        d = int(do.split()[2])
        i = preorder.index(v)  # O(N)의 시간복잡도
        update(i, d)  # O(logN)
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
