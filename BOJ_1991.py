#트리순회
#tree

import sys

n = int(input())
tree = {}

for _ in range(n):
    root, left, right = sys.stdin.readline().strip().split()
    tree[root] = [left, right]

def pre(root):
    if root != '.':
        print(root, end ='')
        pre(tree[root][0]) #left
        pre(tree[root][1]) #right

def mid(root):
    if root != '.':
        mid(tree[root][0]) #left
        print(root, end = '')
        mid(tree[root][1]) #right

def post(root):
    if root != '.':
        post(tree[root][0])
        post(tree[root][1])
        print(root, end ='')

pre('A')
print()
mid('A')
print()
post('A')