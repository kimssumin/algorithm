#정렬

import sys

N = int(input())

list = []

for i in range(N):
    list.append(int(sys.stdin.readline()))

list = sorted(list)

for i in list:
    print(i)