#뮤탈리스트
#DP

n = int(input())
scv = list(map(int, input().split()))
while len(scv) < 3:
    scv += [0]
d = [[[-1]*61 for j in range(61)] for i in range(61)]

# d[i][j][k] : scv의 체력이 i,j,k 일때
# 모두 파괴하는 최소 공격횟수


def go(i, j, k):
    if i < 0:
        return go(0, j, k)
    if j < 0:
        return go(i, 0, k)
    if k < 0:
        return go(i, j, 0)
    if i == 0 and j == 0 and k == 0:  # 3개다 모두 파괴된 경우
        return 0
    ans = d[i][j][k]
    if ans != -1:  # memoization
        return ans
    ans = 10000000
    # 모든 6가지 경우의 수에 대한 최소값 비교
    if ans > go(i-1, j-3, k-9):
        ans = go(i-1, j-3, k-9)
    if ans > go(i-1, j-9, k-3):
        ans = go(i-1, j-9, k-3)
    if ans > go(i-3, j-1, k-9):
        ans = go(i-3, j-1, k-9)
    if ans > go(i-3, j-9, k-1):
        ans = go(i-3, j-9, k-1)
    if ans > go(i-9, j-1, k-3):
        ans = go(i-9, j-1, k-3)
    if ans > go(i-9, j-3, k-1):
        ans = go(i-9, j-3, k-1)
    ans += 1
    d[i][j][k] = ans
    return d[i][j][k]


print(go(scv[0], scv[1], scv[2]))

