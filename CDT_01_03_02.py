# 십자모양폭발

n = int(input())
pann = []

for _ in range(n):
    pann.append(list(map(int, input().split())))

r, c = map(int, input().split())
bomb_range = pann[r-1][c-1] - 1

# dif 위왼아래오 기준 0,1,2,3


def bomb(dir, bomb_range):
    pann[r-1][c-1] = 0  # 자기자신 bomb
    if dir == 0:
        # 위쪽방향
        if bomb_range >= r:
            for i in range(r-1):
                pann[i][c-1] = 0
        else:
            for i in range(bomb_range):
                pann[r-2-i][c-1] = 0
    elif dir == 1:
        # 왼쪽방향
        if bomb_range >= c:
            for i in range(c-1):
                pann[r-1][i] = 0
        else:
            for i in range(bomb_range):
                pann[r-1][c-2-i] = 0

    elif dir == 2:
        # 아래방향
        if bomb_range >= n-r+1:
            for i in range(n-r):
                pann[r+i][c-1] = 0
        else:
            for i in range(bomb_range):
                pann[r+i][c-1] = 0

    elif dir == 3:
        # 오른쪽방향
        if bomb_range >= n-c+1:
            for i in range(n-c):
                pann[r-1][c+i] = 0
        else:
            for i in range(bomb_range):
                pann[r-1][c+i] = 0

    # return pann


for b in range(4):
    bomb(b, bomb_range)

for c in range(n):
    temp = []
    for r in range(n):
        if (pann[r][c] != 0):
            temp.append(pann[r][c])
    fill = [0 for _ in range(n-len(temp))]
    temp = fill + temp
    for rr in range(n):
        pann[rr][c] = temp[rr]

for i in range(n):
    print(*pann[i])
