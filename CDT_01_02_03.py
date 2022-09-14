n, m, q = map(int, input().split())
city = []
wind = []

for _ in range(n):
    city.append(list(map(int, input().split())))


def move(row, dir):
    if (dir == 'R'):
        temp = city[row][m-1]
        for i in range(m - 1, 0, -1):
            city[row][i] = city[row][i - 1]
        city[row][0] = temp

    elif (dir == 'L'):
        temp = city[row][0]
        for i in range(0, m-1):
            city[row][i] = city[row][i + 1]
        city[row][m-1] = temp


def check(row1, row2):
    return any([
        city[row1][col] == city[row2][col]
        for col in range(0, m)
    ])


def flip(curr_dir):
    return 'R' if curr_dir == 'L' else 'L'


def simulate(start_row, start_dir):

    move(start_row-1, start_dir)
    start_dir = flip(start_dir)

    curr_dir = start_dir
    for row in range(start_row-1, 0, -1):
        if check(row, row - 1):
            move(row - 1, curr_dir)
            curr_dir = flip(curr_dir)
        else:
            break

    # 아래방향
    curr_dir = start_dir
    for row in range(start_row-1, n-1):
        if check(row, row + 1):
            move(row + 1, curr_dir)
            curr_dir = flip(curr_dir)
        else:
            break


for _ in range(q):
    r, d = map(str, input().split())
    r = int(r)
    #wind = [(r, d), (r2, d2)]
    simulate(r, 'R' if d == 'L' else 'L')

for row in range(0, n):
    for col in range(0, m):
        print(city[row][col], end=" ")
    print()
