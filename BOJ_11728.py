#배열 합치기 

import sys

input = sys.stdin.readline
n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

res = sorted(a+b)
print(" ".join(map(str, res)))