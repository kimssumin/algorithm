# 상하좌우 우선순위 index로 구분
# 숫자가 더 큰 인접한 곳으로 이동
# simulation

n, r, c = map(int, input().split())
pann = []
for _ in range(n):
    pann.append(list(map(int, input().split())))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
base_x = r-1
base_y = c-1
answer = []
answer.append(pann[base_x][base_y])

while(1):
    lists = []
    base = pann[base_x][base_y]
    for i in range(4):
        if base_x+dx[i] > n or base_y+dy[i] > n or base_x+dx[i] < 0 or base_y+dy[i] < 0:
            continue
        else:
            if pann[base_x+dx[i]][base_y+dy[i]] > base:
                lists.append([base_x+dx[i], base_y+dy[i]])

    if len(lists) == 0:
        break
    else:
        print('hi')
        base_x = lists[0][0]
        base_y = lists[0][1]
        answer.append(pann[base_x][base_y])

print(*answer)
