# 좀비월드
# -n부터 n까지의 정수 아이디를 가진 좀비 n명이 절벽으로 떨어지는 k 번째 좀비 찾기
# greedy

from collections import deque

n, L, k = map(int, input().split())
jombie = [0] * (L+1)
drop = []
locs = deque()  # deque 를 이용

for _ in range(n):
    loc, ids = map(int, input().split())
    locs.append(loc)
    jombie[loc] = ids

while (len(drop) == k):
    bump = []
    cnt = 0
    for i in range(len(locs)):  # 좀비가 존재하는 곳의 index를 돌면서
        if jombie[locs[i]] < 0:  # 좀비가 존재하는 곳에서의 id 가 음수값이라면
            if locs[i] - 1 < 0:  # 왼쪽 절벽으로 떨어지는 경우
                drop.append(jombie[locs[i]])
                jombie[locs[i]] = 0
                locs.popleft()
                cnt += 1
                # 이렇게 진행할 겨우 한바퀴를 다 돌면 loc 은 새로운 위치들로 재배치된다.

            else:  # 절벽으로 떨어지지 않는 경우
                if (locs[i] - 1) in bump:
                    nomove = True
                    jombie[locs[i]] = -1 * jombie[locs[i]]
                    pass
                else:
                    jombie[locs[i]-1] = jombie[locs[i]]  # 왼쪽으로 좀비 이동
                    jombie[locs[i]] = 0
                    locs.append(locs[i] - 1)  # 왼쪽으로 한칸 이동한 지점의 좌표를 append
                    bump.append(locs[i] - 1)  # 이번 턴에 충돌하는 게 있는 지 check
                    locs.popleft()  # 기존의 좌표는 pop

        else:
            if locs[i] + 1 > L:  # 오른쪽 절벽으로 떨어지는 경우
                drop.append(jombie[locs[i]])
                jombie[locs[i]] = 0
                locs.popleft()
                cnt += 1
            else:
                if (locs[i] + 1) in bump:
                    nomove = True
                    jombie[locs[i]] = -1 * jombie[locs[i]]
                    pass
                else:
                    jombie[locs[i]+1] = jombie[locs[i]]  # 오른쪽으로 좀비 이동
                    jombie[locs[i]] = 0
                    locs.append(locs[i] + 1)  # 오른쪽으로 한칸 이동한 지점의 좌표를 append
                    locs.popleft()  # 기존의 좌표는 pop
    if cnt == 2:
        if drop[-2] < drop[-1]:  # 작은거부터 잘 들어간 경우
            pass
        elif drop[-2] > drop[-1]:
            first = drop[-2]
            second = drop[-1]
            drop[-2] = second
            drop[-1] = first  # 순서 바꿔 넣기


print(drop[k-1])
