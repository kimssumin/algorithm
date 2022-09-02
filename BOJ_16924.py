# brute force
# 십자가 찾기

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(input().rstrip()))

# (board)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def check(i, j):
    returns = False
    for x in range(4):
        if (board[i+dx[x]][j+dy[x]] != '*'):
            returns = False
            break
        else:
            returns = True
    return returns


def check_s(i, j):
    s = []
    cnt = 0
    # left
    # 한쪽 방향을 먼저 확인하고 나머지도 조건을 만족하는지
    for jj in range(0, j):
        if board[i][jj] == '*':
            cnt += 1
        else:
            cnt = 0
    #up, right, down
    for k in range(1, cnt+1):
        if(i >= k and i+k <= n-1 and j >= k and j+k <= m-1):
            if (board[i-k][j] == '*' and board[i+k][j] == "*" and board[i][j-k] == "*" and board[i][j+k] == '*'):
                # success
                s.append(k)
            else:
                return s

    return s


ans = []
answer = False

for i in range(1, n):
    for j in range(1, m):
        if (board[i][j] == '*') and (check(i, j) == True):
            answer = True 
            for x in check_s(i, j): 
                ans_list = [i+1, j+1, x]
                ans.append(ans_list)


if (answer == True):
    print(len(ans))
    for l in ans:
        print(*l)

else:
    print(-1)
