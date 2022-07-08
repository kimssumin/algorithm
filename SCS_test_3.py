
def sum(a, b, c, d):
    w = S[c][d]
    x = 0 if b == 0 else S[c][b-1]
    y = 0 if a == 0 else S[a-1][d]
    z = 0 if a == 0 or b == 0 else S[a-1][b-1]
    return w - x - y + z


m, n = [int(x) for x in input().split()]
A = [[int(x) for x in input().split()] for _ in range(m)]
S = [[A[i][j] for j in range(n)] for i in range(m)]

for i in range(m):  # 2D prefix sum
    for j in range(n-1):
        S[i][j+1] += S[i][j]

for i in range(m-1):  # 2D prefix sum
    for j in range(n):
        S[i+1][j] += S[i][j]

cnt = 0
for a in range(m):
    for b in range(n):
        rbnd = min(a+15, m)
        for c in range(a, rbnd):
            dist = c - a
            cbnd = min(b+15-dist+1, n)
            for d in range(b, cbnd):
                if sum(a, b, c, d) == 15:
                    cnt += 1
print(cnt)
