#기본적인 서로소 집합 자료구조

def find_parent(parent, x): #특정원소가 속한 집합
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if  a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split())
parent = [0]*(v+1)

for i in range(1, v+1): #부모테이블상에서 부모를 자기자신으로 초기화
    parent[i] = i

for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b) #union 연산 수행

print('각 원소가 속한 집합: ', end = '') #1부터 6까지 각 원소의 루트노트
for i in range(1, v+1):
    print(find_parent(parent, i), end = ' ')

print()

print('부모테이블 : ', end = "")
for i in range(1, v+1):
    print(parent[i], end = " ")