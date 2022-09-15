# 십자모양폭발

n = int(input())
pann = []

for _ in range(n):
    pann.append(list(map(int, input().split())))

r, c = map(int, input().split())
bomb_range = pann[r-1][c-1] - 1
