#벽 부수고 이동하기
#bfs

import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# 방문 확인용 배열
visited = [[[0 for _ in range(M)] for _ in range(N)] for _ in range(2)]
# 인풋으로 받을 배열
field = []

for _ in range(N):
    field.append(list(map(int, sys.stdin.readline().strip())))

queue = deque()

# 시작점이 완료점일 경우
if N == 1 and M == 1 and field[0][0] == 0:
    print(1)
else:
    visited[0][0][0] = 1
    queue.append([0, 0, 0])

    flag = 0
    while queue:
        x, y, z = queue.popleft()

        for i in range(4):
            ndr = x + dr[i]
            ndc = y + dc[i]

            # 범위안에 들어옴
            if 0 <= ndr < N and 0 <= ndc < M and visited[z][ndr][ndc] == 0:

                c = 0
                # 벽을 만났는데 아직 벽을 안뚫어봄
                if field[ndr][ndc] == 1 and z == 0:
                    visited[1][ndr][ndc] = visited[0][x][y] + 1
                    queue.append([ndr, ndc, 1])
                    c = 1
				
                # 벽 안만남 (길을 만난 경우)
                elif field[ndr][ndc] == 0:
                    visited[z][ndr][ndc] = visited[z][x][y] + 1
                    queue.append([ndr, ndc, z])

                # 도착한 경우
                if ndr == N-1 and ndc == M-1:
                    print(visited[z][ndr][ndc])
                    flag = 1
                    break

        if flag == 1:
            break

    if flag == 0:
        print(-1)