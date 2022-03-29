# 샛강 건너기
# 폭 L, n 개의 돌, 시작위치 0 , 끝나는 위치 L
# 인접한 돌 사이의 최소 거리 이상 점프

import sys
l, n, k = map(int, input().split())
input = sys.stdin.readline
stone = list(map(int, input().split()))
dis = [stone[0]]

for x in range(1, len(stone)):
    dis.append(stone[x] - stone[x-1])
dis.append(l - stone[n-1])
# print(dis)

for kk in range(1, k+1):
    min_dis = 1e9
    for y in range(len(dis)):
        if dis[y] < min_dis:
            min_dis = dis[y]
            min_ind = y

    new_dis = [0] * (n+1-kk)
    for a in range(n+1-kk):
        if a < y-1:
            new_dis[a] = dis[a]
        elif a == y-1:
            new_dis[a] = dis[a+1] + dis[a]
        else:
            new_dis[a] = dis[a+1]
    dis = new_dis
    print(dis)
    result = min(dis)

print(result)
