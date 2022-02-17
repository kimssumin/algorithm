#나이순 정렬
#sort

import sys

n = int(input())
input = sys.stdin.readline
member = []

for _ in range(n):
    age, name = map(str, input().split())
    age = int(age)
    member.append([age, name])
