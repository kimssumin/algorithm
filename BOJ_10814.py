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
member.sort(key = lambda x : x[0]) #age 만 비교
for i in member:
    print(" ".join(map(str, i)))
