# 유사성 검사하기
# 두 수열이 얼마나 유사한지 유사트리플 정의
# P[i] < P[j] < P[k] 이면서 Q[i] < Q[j] < Q[k]인 인덱스 (i, j, k)가 존재
# 유사도는 유사 트리플의 개수로 정의

# BIT(fenwick tree)


import sys

input = sys.stdin.readline
n = int(input())
arr_p = list(map(int, input().split()))
arr_q = list(map(int, input().split()))
dp_p = [[0] * int(n + 2) for _ in range(4)]
dp_q = [[0] * int(n + 2) for _ in range(4)]


def q(p, k):
    s = 0
    while p:
        # if dp_p[k][p] == dp_q[k][p]:
        s = (s + dp_p[k][p])
        p -= (p & -p)
    return s


def u_p(p, k, v):
    while p <= n + 1:
        dp_p[k][p] = (dp_p[k][p] + v)
        p += (p & -p)


def u_q(p, k, v):
    while p <= n + 1:
        dp_q[k][p] = (dp_q[k][p] + v)
        p += (p & -p)


#u_p(1, 0, 1)
#u_q(1, 0, 1)

for i in arr_p:
    for j in range(1, 4):
        u_p(i + 1, j, q(i, j - 1))

for i in arr_q:
    for j in range(1, 4):
        u_q(i + 1, j, q(i, j - 1))


print(q(n + 1, 3))
