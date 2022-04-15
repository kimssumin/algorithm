# 조상 확인하기
# DFS(Depth First Search) 탐색을 하면서 preorder 순서와 postorder 순서를 정의할 수 있다
# 현재 방문 노드의 자식 노드는 노드 번호의 오름차순 순서로 차례대로 방문한다고 가정한다
# dfs
# 시간복잡도 제일 최악의 경우 모든 질의에서 조상 노드까지 검색해야 하는 경우 (O(Q * (N-1))

import sys
sys.setrecursionlimit(10**7)

n, q = map(int, input().split())
tree = [[] for _ in range(n+2)]  # tree 구조 입력받음
parents = [-1 for _ in range(n+2)]  # 부모 찾는 리스트

for _ in range(n-1):  # O(N-1)
    p, c = map(int, input().split())
    tree[p].append(c)
    tree[c].append(p)

cnt = 0  # 답이 True인 질의의 갯수


def dfs(n):
    for i in tree[n]:  # 최악의 경우 O(N-1)
        if parents[i] == -1:
            parents[i] = n
            dfs(i)


dfs(1)  # dfs(1) 실행을 통해 각 자식노드의 부모노드를 parents 리스트에 저장


def parents_up(u, v):  # 부모를 넘어 조상에 있는지 check
    check = parents[v]  # u가 v의 조상노드인지 체크하기 위해
    # 가장 위 부모노드까지 올라가면서 u와 일치하는게 있는지 check  -> 최악의 경우 O(N-1)
    while check != 1 and parents[check] >= 1:
        if parents[check] == 1:
            return False
        if parents[check] == u:
            return True
            break
        check = parents[check]


for _ in range(q):  # O(Q) 의 시간복잡도
    u, v = map(int, input().split())
    if u == v:  # 자기자신은 자기자신의 조상이므로 무조건 + 1
        cnt += 1
    elif u == 1:  # 루트노드 1은 최상위 노드이므로 모든 노드의 조상노드일것이다
        cnt += 1
    elif parents[v] == u:  # 바로 위 부모노드일 경우
        cnt += 1
    elif parents_up(u, v):  # 조상 노드일 경우
        cnt += 1

print(cnt)  # True인 질의의 갯수 출력
