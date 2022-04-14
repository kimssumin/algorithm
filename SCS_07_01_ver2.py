
# 필사의 탈출

# 남왕국으로 자객의 탈출 - 장벽 세개 통과
# 통로의 개수
#

from itertools import permutations, product

u = int(input())  # 가장 위 구멍의 수
uu = list(map(int, input().split()))  # 가장 위 구멍의 x 좌표
m = int(input())  # 중간 구멍의 수
mm = list(map(int, input().split()))  # 중간 구멍의 x 좌표
l = int(input())  # 가장 아래 구멍의 수
ll = list(map(int, input().split()))  # 가장 아래 구멍의 x 좌표

cnt = 0
all_li = [uu, mm, ll]

case_li = list(product(*all_li))
# print(case_li)  # (all_li, 3)))

for i in case_li:
    if 2 * i[1] == i[0] + i[2]:
        cnt += 1
print(cnt)
