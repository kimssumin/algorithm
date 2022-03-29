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
    #print(min_ind, min_dis)

    new_dis = [0] * (len(dis)-1)

    if min_ind == 0:
        for a in range(len(dis)-1):
            if a == 0:
                new_dis[a] = dis[a] + dis[a+1]
            else:
                new_dis[a] = dis[a+1]
    else:
        for a in range(len(dis)-1):
            if a < min_ind-1:
                new_dis[a] = dis[a]
            elif a == min_ind-1:
                new_dis[a] = dis[a] + dis[a+1]
            else:
                new_dis[a] = dis[a+1]
    dis = new_dis
    print(dis)
    result = min(dis)

print(result)
