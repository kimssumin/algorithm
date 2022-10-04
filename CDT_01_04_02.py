# 떨어지는 1차 블록
# simulation

n, m, k = map(int, input().split())
pann = []
for _ in range(n):
    pann.append(list(map(int, input().split())))


def all_blank(row, col_s, col_e):
    return all([
        not pann[row][col]
        for col in range(col_s, col_e + 1)
    ])


def get_target_row():
    for row in range(n - 1):
        if not all_blank(row + 1, k, k + m - 1):
            return row

    return n - 1


k -= 1

target_row = get_target_row()

for col in range(k, k + m):
    pann[target_row][col] = 1


for i in pann:
    print(*i)
