#DP
#정수 삼각형

import sys
n = int(input())
tree =[]
input = sys.stdin.readline
for _ in range(n):
    tree.append(list(map(int, input().split())))

for i in range(1,n):
    for j in range(len(tree[i])) :
        if j == 0: #첫자리
            tree[i][j] = tree[i][j] + tree[i-1][j]
        elif j == len(tree[i]) - 1 : #끝자리
            tree[i][j] = tree[i][j] + tree[i-1][j-1]
        else: #중간자리
            tree[i][j] = max(tree[i-1][j-1], tree[i-1][j]) + tree[i][j]

print(max(tree[n-1])) #트리 젤 밑에서 가장 큰 수 