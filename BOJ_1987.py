#알파벳
#bruteforce
#bfs

#test case 전부 잘 출력되는데 왜 틀렸다하는거니?!?!?!
import sys
from collections import deque

input = sys.stdin.readline
r, c = map(int, input().split())
board = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for _ in range(r):
    board.append(list(input()))
board_n = len(board)
board_m = len(board[0])


def bfs(board):
    global result 
    q = set()
    q.add((0,0, board[0][0]))
    result= 1
    while q:
        x, y, res = q.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= board_m or ny < 0 or ny >= board_n:
                continue
            if board[ny][nx] in res:
                continue
            q.add((nx, ny, res + board[ny][nx]))
            result = max(result, len(res)+1)
    return result


print(bfs(board))