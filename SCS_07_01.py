# 필사의 탈출

# 남왕국으로 자객의 탈출 - 장벽 세개 통과
# 통로의 개수

u = int(input())  # 가장 위 구멍의 수
uu = list(map(int, input().split))  # 가장 위 구멍의 x 좌표
m = int(input())  # 중간 구멍의 수
mm = list(map(int, input().split))  # 중간 구멍의 x 좌표
l = int(input())  # 가장 아래 구멍의 수
ll = list(map(int, input().split))  # 가장 아래 구멍의 x 좌표

for m_i in mm:
    check_m = 2 * (m_i)
