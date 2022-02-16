#좌표 정렬하기
#sort

import sys
n = int(input())
maps = []
input = sys.stdin.readline
for _ in range(n):
    maps.append(list(map(int, input().split())))

maps.sort()
print(" ".join(map(str, maps)))
