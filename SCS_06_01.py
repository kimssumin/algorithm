# 좀비월드
# -n부터 n까지의 정수 아이디를 가진 좀비 n명이 절벽으로 떨어지는 k 번째 좀비 찾기
# greedy

from collections import deque

n, L, k = map(int, input().split())
jombie = [0] * (L+1)
drop = []
locs = []  # deque 를 이용
new_locs = []
new_jombie = [0] * (L+1)
idss = []

for _ in range(n):
    loc, ids = map(int, input().split())
    idss.append(ids)
    locs.append(loc)
    jombie[loc] = ids

nomove = []

while (len(drop) <= k):
    bump = []
    cnt = 0
    # print(locs)

    print(locs)
    new_locs = []
    new_jombie = [0] * (L+1)

    for i in range(len(locs)):  # 좀비가 존재하는 곳의 index를 돌면서
        ll = locs[i]
        #print(ll, nomove)
        if ll in nomove:
            new_locs.append(ll)
            new_jombie[ll] = jombie[ll]
            bump.append(ll)
            nomove.remove(ll)
            # print("Q")

        else:
            #     nomove = False
            # # print(ll)
            # else:
            if jombie[ll] < 0:  # 좀비가 존재하는 곳에서의 id 가 음수값이라면
                if locs[i] - 1 < 0:  # 왼쪽 절벽으로 떨어지는 경우
                    #nomove = False
                    drop.append(jombie[ll])
                    new_jombie[ll] = 0
                    # locs.popleft()
                    cnt += 1
                    #print(new_jombie, 1)
                    # 이렇게 진행할 겨우 한바퀴를 다 돌면 loc 은 새로운 위치들로 재배치된다.

                else:  # 절벽으로 떨어지지 않는 경우
                    if (locs[i] - 1) in bump:  # 부딪히는 경우
                        #nomove = True

                        change_index = locs[i] - 1
                        # 기존에 있던 걸 마이너스로 바꾸고
                        # print(change_index)
                        new_jombie[change_index] = (-1) * \
                            (new_jombie[change_index])

                        #print("기존꺼: " + str(new_jombie[change_index]))

                        if new_jombie[change_index] < 0:
                            new_jombie[change_index -
                                       1] = new_jombie[change_index]
                            new_jombie[change_index] = 0
                            ch = new_locs.index(change_index)
                            new_locs[ch] = change_index - 1
                            nomove.append(change_index - 1)

                        else:
                            new_jombie[change_index +
                                       1] = new_jombie[change_index]
                            new_jombie[change_index] = 0
                            ch = new_locs.index(change_index)
                            new_locs[ch] = change_index + 1
                            nomove.append(change_index + 1)
                        # 위의 과정으로 앞에있던 겹친거 해결

                        new_jombie[ll] = jombie[ll] * (-1)
                        new_locs.append(ll)
                        nomove.append(ll)

                        #print(new_jombie, 2)
                        # pass

                    else:
                        new_jombie[ll-1] = jombie[ll]  # 왼쪽으로 좀비 이동
                        jombie[ll] = 0
                        # 왼쪽으로 한칸 이동한 지점의 좌표를 append
                        new_locs.append(locs[i] - 1)
                        bump.append(locs[i] - 1)  # 이번 턴에 충돌하는 게 있는 지 check
                        # locs.popleft()  # 기존의 좌표는 pop
                        #nomove = False
                        #print(new_jombie[ll-1], 3)

            else:
                if locs[i] + 1 > L:  # 오른쪽 절벽으로 떨어지는 경우
                    # new_locs.append(locs[i])
                    drop.append(jombie[ll])
                    new_jombie[ll] = 0
                    # locs.popleft()
                    cnt += 1
                    #nomove = False
                    #print(new_jombie, 4)
                else:
                    if (locs[i] + 1) in bump:  # 부딪히는 경우
                        #nomove = True

                        change_index = locs[i] + 1
                        # 기존에 있던 걸 마이너스로 바꾸고
                        new_jombie[change_index] = (-1) * \
                            (new_jombie[change_index])

                        if new_jombie[change_index] < 0:
                            new_jombie[change_index -
                                       1] = new_jombie[change_index]
                            new_jombie[change_index] = 0
                            ch = new_locs.index(change_index)
                            new_locs[ch] = change_index - 1
                            nomove.append(change_index - 1)
                        else:
                            new_jombie[change_index +
                                       1] = new_jombie[change_index]
                            new_jombie[change_index] = 0
                            ch = new_locs.index(change_index)
                            new_locs[ch] = change_index + 1
                            nomove.append(change_index + 1)
                        # 위의 과정으로 앞에있던 겹친거 해결

                        new_jombie[ll] = jombie[ll] * (-1)
                        new_locs.append(ll)

                        #print(new_jombie, 5)

                    else:
                        new_jombie[ll+1] = jombie[ll]  # 오른쪽으로 좀비 이동
                        jombie[ll] = 0
                        # 오른쪽으로 한칸 이동한 지점의 좌표를 append
                        new_locs.append(locs[i] + 1)
                        # locs.popleft()  # 기존의 좌표는 pop
                        bump.append(locs[i] + 1)
                        #nomove = False
                       # print(new_jombie[ll+1], 6)

    if cnt == 2:
        for aa in idss:
            if abs(aa) == abs(drop[-2]):  # drop2가 먼저 들어간것
                drop2 = aa
            elif abs(aa) == abs(drop[-1]):
                drop1 = aa
        print(drop1, drop2)

        if drop2 > drop1:  # 먼저들어간게 크면
            first = drop2  # 서로 교환해야됨
            second = drop1
            drop[-2] = second
            drop[-1] = first  # 순서 바꿔 넣기
           # print(new_jombie, 8)

    locs = new_locs
    jombie = new_jombie
    #print("좀비상태 : ")
    # print(jombie)
    bump = []

for a in idss:
    if abs(a) == abs(drop[k-1]):
        drop[k-1] = a

print(drop[k-1])
