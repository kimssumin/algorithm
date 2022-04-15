# 비용 합 질의
# n개의 노드에 비용(cost, weight) 주어짐, m 개의 에지
# subtree 함수는 부트리에 포함된 노드의 비용을 모두 더해서 return (자기자신도 포함)
# update 함수는 노드 v 비용을 d만큼 더함

n, q = map(int, input().split())
cost = list(map(int, input().split()))
tree = [[] for _ in range(n+2)]
for _ in range(n-1):
    p, c = map(int, input().split())
    tree[p].append(c)
    tree[c].append(p)
for _ in range(q):
    do, v = map(str, input().split())
    v = int(v)
    if do.startswith('sub'):
        # subtree
    else:
        # query_update
