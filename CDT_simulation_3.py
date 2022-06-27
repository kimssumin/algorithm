# 트로미노

n, m = map(int, input().split())
num = []
answer = []

for _ in range(n):
    num.append(list(map(int, input().split())))
row = len(num)
col = len(num[0])


def block1(i, j):
    minn = min(num[i][j], num[i+1][j], num[i+1][j+1], num[i][j+1])
    sums = num[i][j] + num[i+1][j] + num[i+1][j+1] + num[i][j+1]
    return sums - minn


def block2(i, j):
    sums = num[i][j] + num[i][j+2] + num[i][j+1]
    return sums


def block3(i, j):
    sums = num[i][j] + num[i+1][j] + num[i+2][j]
    return sums


minn = 0
for i in range(row-1):
    for j in range(col-1):
        a = block1(i, j)
        maxx = max(a, minn)
        answer.append(maxx)

minn = 0
for i in range(row):
    for j in range(col-2):
        b = block2(i, j)
        maxx = max(b, minn)
        answer.append(maxx)


minn = 0
for i in range(row-2):
    for j in range(col):
        c = block3(i, j)
        maxx = max(c, minn)
        answer.append(maxx)

print(max(answer))
