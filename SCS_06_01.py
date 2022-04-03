# 좀비월드
# -n부터 n까지의 정수 아이디를 가진 좀비 n명이 절벽으로 떨어지는 k 번째 좀비 찾기
# greedy

n, L, k = map(int, input().split())
jombie = [0] * (L+1)
drop = []
locs = []

for _ in range(n):
    loc, ids = map(int, input().split())
    locs.append(loc)
    jombie[loc] = ids

while (len(drop) == k):
    for i in range(n):
        if jombie[locs[i]] < 0:  # 좀비가 존재하는 곳에서의 id 가 음수값이라면
            if locs[i] - 1 < 0:  # 왼쪽 절벽으로 떨어지는 경우
                drop.append(jombie[locs[i]])
                jombie[locs[i]] = 0
            else:  # 절벽으로 떨어지지 않는 경우
                jombie[locs[i]-1] = jombie[locs[i]]  # 왼쪽으로 좀비 이동
                jombie[locs[i]] = 0
        else:
            if locs[i] + 1 > L:  # 오른쪽 절벽으로 떨어지는 경우
                drop.append(jombie[locs[i]])
                jombie[locs[i]] = 0
            else:
                jombie[locs[i]+1] = jombie[locs[i]]  # 오른쪽으로 좀비 이동
                jombie[locs[i]] = 0
