# 경로 합 질의


# 최악의 경우에도 O(n ^ 2/2)보단 적은 시간복잡도
#dfs, fenwick

import sys
input = sys.stdin.readline


n, q = map(int, input().split())
# 초기 cost 입력 -> 추후에 preorder 순으로 재배열됨
cost_init = list(map(int, input().split()))
cnts_init = []  # 자식노드 수를 count 할 리스트 -> 이 또한 추후에 preorder 순으로 재배열됨
tree = [[] for _ in range(n+2)]
for _ in range(n-1):  # O(n)
    p, c = map(int, input().split())
    tree[p].append(c)

visited = [0] * (n+1)  # 방문확인용
preorder = [1]  # preorder 순으로 재배열될 tree 리스트, 루트노드는 1
level = [0] * (n + 1)  # 각 노드의 레벨
# preorder 순으로 재배열될 cost_init 리스트, 모든 경우 젤 높은 루트노드는 1이므로 1일때의 cost를 먼저 넣어둠
cost = [cost_init[0]]
path_sum = [cost_init[0]]
parents = [-1 for _ in range(n+2)]  # 부모 찾는 리스트


def dfs(n):
    for i in tree[n]:  # 최악의 경우 O(N-1)
        if parents[i] == -1:
            parents[i] = n
            dfs(i)


dfs(1)  # dfs(1) 실행을 통해 각 자식노드의 부모노드를 parents 리스트에 저장


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
diff = [path_sum[0]]  # diff 배열


def dfs(x, l):  # preorder list 함수
    visited[x] = True
    level[x] = l
    pa = 0
    p_sum = cost_init[0]

    if level[x] >= 2:
        for a in range(level[x] - 1):  # O(level 수 만큼 (자식노드의 깊이만큼)) -> 최악의 경우에도 O(N)
            if a >= 1:
                xx = x
                xx = parents[xx]
                p_sum += cost_init[parents[xx] - 1]
            else:
                p_sum += cost_init[parents[x] - 1]
        path_sum[-1] += (p_sum - cost_init[0])
        diff[-1] += (p_sum - cost_init[0])

    p_sum = cost_init[0]

    for i in tree[x]:  # 시간복잡도 : O(tree[x]의 자식노드 수) -> 젤 최악의 경우에도 O(n)
        if not visited[i]:
            p_sum += cost_init[i-1]
            #parent[i] = x
            preorder.append(i)
            cost.append(cost_init[i-1])  # cost 작성 (preorder 순으로)
            cnts.append(cnts_init[i-1])  # 자식노드 갯수 count (preorder 순으로)

            path_sum.append(p_sum)
            diff.append(path_sum[-1] - path_sum[-2])
            p_sum = cost_init[0]

            dfs(i, l+1)


dfs(1, 0)  # preorder list 작성 O(N)
# print(preorder)
# print(cost)
# print(path_sum)
# print(diff)


def LSB(k):  # k의 오른쪽에서 첫번째 1의 비트 위치가 d 번째라면 2^d return
    return k & -k


T_diff = []  # BIT 트리 작성
for a in range(len(diff)):  # O(n) 시간복잡도
    if a % 2 == 0:  # index number 기준 짝수일때 (bit tree 기준 홀수일때)
        T_diff.append(diff[a])  # 자기 자신 하나만 저장
    else:
        cc = 0
        for k in range(a, a - LSB(a+1), -1):  # O(LSB(a+1))만큼의 시간복잡도
            cc += diff[k]
        T_diff.append(cc)
# print(T_diff)


def prefix_sum(k):  # prefix_sum 의 수행시간은 O(logN)
    s = 0
    while k >= 1:
        s += T_diff[k-1]
        k = k - LSB(k)
    return s


# print("prefix")
# print(prefix_sum(4))  # diff[4]까지의 합


def update(k, x):  # T_diff[k]를 x+T_diff[k]로 change
    while k <= n:  # (O(logN))
        T_diff[k] = T_diff[k] + x
        k = k + LSB(k+1)  # O(1)


def update_minus(k, x):  # T_diff[k]를 T_diff[k] - x로 change
    while k < n:  # (O(logN))
        T_diff[k] = T_diff[k] - x
        k = k + LSB(k+1)  # O(1)


# 시간복잡도 O(q * n)
for _ in range(q):  # 질의
    do = str(input())
    #v = int(v)
    if do.startswith('sum'):  # subtree 질의가 들어온다면
        v = int(do.split()[1])
        i = preorder.index(v)  # O(N)의 시간복잡도

        result_sub = prefix_sum(i+1)  # O(logn)
        print(result_sub)

    else:
        v = int(do.split()[1])
        d = int(do.split()[2])
        k = preorder.index(v)  # O(N)의 시간복잡도
        s = cnts[k]
        update(k, d)  # O(logN)
        # print(k+s)
        update_minus(k+s, d)  # O(logN)

        # cost[k] = d + cost[k]  # 비용 업데이트

        # if cnts[-2] == 1 and level[preorder[-2]] == level[x]:
        #     k = -3

        #     while cnts[k] == 1 and level[preorder[k]] == level[x]:
        #         k -= 1
        #     p_sum += cost_init[preorder[((-1) * (a+1)) + (k+1)] - 1]
        #     #k = -3
        # else:
