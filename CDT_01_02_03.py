n, m, q = map(int, input().split())
city = []
wind = []

for _ in range(n):
    city.append(list(map(int, input().split())))

for _ in range(q):
    r, d = map(int, input().split())
    #wind = [(r, d), (r2, d2)]
    if (d == 'L'):
      # r-1 : 행

    else:
      # R


def check(row, d):
    if row == d:
        # 양방향 모두 검사
        for i in range(len(city[row])):
            if (city[row][i] == city[row-1][i]) or (city[row][i] == city[row+1][i]):
                return True
    elif row > d:
        # 아래 방향 검사
    else:
        # 위방향 검사
        for i in range(len(city[row])):
