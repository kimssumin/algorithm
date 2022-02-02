#트리의 높이
#tree

from ast import Num
import sys

n = int(input())
tree = {}
level = [[] for _ in range(n+1)]
node = [0 for _ in range(n + 1)]

for _ in range(n):
    root, left, right = map(int, sys.stdin.readline().strip().split())
    tree[root] = [left, right]
    node[root] += 1
    if left != -1 :
        node[left] += 1
    if right != -1 :
        node[right] += 1

for i in range(1, n + 1):
    if node[i] == 1:
        root = i
        
def mid(start, deep):
    global num
    if tree[start][0] != -1:
        mid(tree[start][0], deep+1)
    level[deep].append(num)
    num += 1
    if tree[start][1] != -1:
        mid(tree[start][1], deep+1)

num = 1
mid(root, 1)
lv = 1
result = max(level[1]) - min(level[1]) + 1

for i in range(2, n+1):
    if level[i]:
        s = min(level[i])
        l = max(level[i])
        if result < l - s + 1:
            result = l - s + 1
            lv = i
print(lv,result)



