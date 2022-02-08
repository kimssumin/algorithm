#동전 0
#greedy

import sys

input = sys.stdin.readline

n, k = map(int, input().split())
A_l = []

for _ in range(n):
    A_l.append(int(input().strip()))
  