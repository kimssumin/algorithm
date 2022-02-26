#늑대와 양
#BFS

import sys
r, c = map(int ,input().split())
input = sys.stdin.readline
farm = []
for _ in range(r):
    farm.append(list(input()))

sign = False #늑대가 양한테 갈 수 있는지
for i in range(r):
    for j in range(c):
        if farm[i][j] == "W": #늑대일 경우
            dx = [-1, 1, 0, 0]
            dy = [0, 0, -1, 1]
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]

                if 0 <= nx < r and 0 <= ny < c and farm[nx][ny] == "S":
                    sign = True
                    break
                
        elif farm[i][j] == "S": #양일 경우
            continue

        elif farm[i][j] == ".": #빈칸일 경우
            farm[i][j] = "D"

if sign:
    print(0)
else:
    print(1)
    for i in farm:
        print("".join(i))