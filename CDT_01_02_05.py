# 기울어진 직사각형의 회전
# simulation
n = int(input())
pann = []
for _ in range(n):
    pann.append(list(map(int, input().split())))
r, c, m1, m2, m3, m4, dir = map(int, input().split())

row = [r-1]
col = [c-1]


rr = r-1
cc = c-1
# 1번방향
for _ in range(m1):
    rr -= 1
    cc += 1
    row.append(rr)
    col.append(cc)

# 2번방향
for _ in range(m2):
    rr -= 1
    cc -= 1
    row.append(rr)
    col.append(cc)

# 3번방향
for _ in range(m3):
    rr += 1
    cc -= 1
    row.append(rr)
    col.append(cc)

# 4번방향
for _ in range(m4):
    rr += 1
    cc += 1
    row.append(rr)
    col.append(cc)


def move(dir):
    if dir == 0:
        temp = pann[rr][cc]
        for i in range(len(col)-1, 0, -1):
            pann[row[i]][col[i]] = pann[row[i-1]][col[i-1]]

        pann[row[1]][col[1]] = temp
    else:
        row.reverse()
        col.reverse()
        temp = pann[rr][cc]
        for i in range(len(col)-1, 0, -1):
            pann[row[i]][col[i]] = pann[row[i-1]][col[i-1]]
        pann[row[1]][col[1]] = temp


move(dir)
for j in range(len(pann)):
    print(*pann[j])
