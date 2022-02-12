#단어정렬


import sys

n = int(input())
lists = []

for i in range(n):
    lists.append(sys.stdin.readline().strip())
sets = set(lists)
lists = list(sets)
lists.sort()
lists.sort(key = len)

for i in lists:
    print(i)