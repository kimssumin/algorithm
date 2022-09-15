# 1차원젠가
#

n = int(input())
block = []
for _ in range(n):
    block.append(int(input()))

s1, e1 = map(int, input().split())
s2, e2 = map(int, input().split())

block = block[:s1-1] + block[e1:]
block = block[:s2-1] + block[e2:]

if len(block) == 0:
    print(0)
else:
    print(len(block))
    for i in range(len(block)):
        print(block[i])
