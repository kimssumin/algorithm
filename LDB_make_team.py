#팀결성
#서로소 집합 알고리즘
#경로압축방식을 이용해 시간복잡도 개선

def find_parent(parent, x): #특정원소가 속한 집합을 찾음
    if parent[x] != x : #루트 노드가 아니라면 루트노드를 찾을때까지 재귀
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b): #두 원소가 속한 집합을 합침
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())
parent = [0] * (n+1)

for i in range(0, n+1):
    parent[i] = i

for _ in range(m):
    t, a, b = map(int, input().split())
    if t == 0:
        union_parent(parent, a, b)
    elif t == 1:
        if find_parent(parent, a) == find_parent(parent, b):
            print('YES')
        else:
            print('NO')