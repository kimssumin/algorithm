# 좀비월드
# -n부터 n까지의 정수 아이디를 가진 좀비 n명이 절벽으로 떨어지는 k 번째 좀비 찾기
# greedy

n, L, k = map(int, input().split())
jombie = [0] * (L+1)
drop = []

for _ in range(n):
    loc, id = map(int, input().split())
    jombie[loc] = id

while (len(drop) == k):
