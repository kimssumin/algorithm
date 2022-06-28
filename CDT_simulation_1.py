# 최고의 33위치

n = int(input())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))


def check(i, j):
    sum = 0
    for a in range(i, i+3):
        for b in range(j, j+3):
            sum += board[a][b]
    return sum


answer = 0

for i in range(0, len(board)-2):
    for j in range(0, len(board)-2):
        #print(check(i, j))
        answer = max(answer, check(i, j))

print(answer)
