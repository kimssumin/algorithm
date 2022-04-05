# 좀비월드
# -n부터 n까지의 정수 아이디를 가진 좀비 n명이 절벽으로 떨어지는 k 번째 좀비 찾기

# greedy
# 시간복잡도 최악의 경우 O(N^3)
# 좀비가 존재하면 그 위치를 index로 하는 곳에 좀비의 방향값을 포함한 id를 value로 가지는 리스트를 순회하며 drop 리스트에 추가되는 좀비의 수가 k개가 될때까지 반복하도록 함

n, L, k = map(int, input().split())  # n, l, k 입력
jombie = [0] * (L+1)  # 좀비의 이동하기 전 위치에 따른 좀비 아이디 리스트
drop = []  # 절벽으로 떨어지는 순서대로 저장될 list
locs = []  # 좀비들의 이동하기 전 위치를 저장해둘 리스트
new_locs = []  # 좀비들의 이동한 후의 위치를 저장해둘 리스트
new_jombie = [0] * (L+1)  # 좀비의 이동한 후 위치에 따른 좀비 아이디 리스트
idss = []  # 좀비들의 초기 아이디를 저장해둘 리스트

for _ in range(n):  # O(N)
    loc, ids = map(int, input().split())  # 위치와 id 를 입력받아
    idss.append(ids)  # 각자의 초기 리스트에 append 하고 (각 O(1))
    locs.append(loc)
    jombie[loc] = ids  # 좀비 리스트의 위치를 인덱스로 하여 좀비가 존재하는 곳에 좀비의 id를 입력하도록 함


nomove = []  # 움직이지 않아야 할 경우 (부딪혀서) 그 위치를 저장해둘 리스트

# 최악의 case : O(N^3)
while (len(drop) < k):  # 절벽에 떨어지는 좀비의 수가 k 명 미만일 동안 반복 -> 전부 다도는 것보다 시간복잡도를 줄일 수 있다 -> 최악의 경우 while 문만 O(N) 번 반복
    bump = []  # 부딪히는 경우를 저장하기 위한 리스트
    cnt = 0  # 부딪히는 횟수를 저장할 변수 cnt

    new_locs = []  # 이 while문을 새로 돌 때마다라는 것은 1초 1거리 이동을 전체 좀비가 마쳤다는 것이고, 새로 다시 이동을 한다는 것이므로, 앞으로 움직일 위치 리스트를 초기화함
    # 위의 설명과 마찬가지로 이번 1초동안 움직이는 좀비의 id 값을 저장할 리스트도 다시 초기화함
    new_jombie = [0] * (L+1)

    for i in range(len(locs)):  # 좀비가 존재하는 곳의 index를 돌면서 -> 불필요하게 도는 것을 방지 (시간복잡도 : O(N))
        ll = locs[i]  # 좀비가 존재하는 곳의 위치 loc 을 정확히 지정해줌
        if ll in nomove:  # nomove 리스트안에 loc 이 있으면 움직이지 말고 한타임 정지해야하므로 검색이 필요
            # 최악의 경우 : 시간복잡도 (O(N))
            new_locs.append(ll)  # 새로운 위치엔 움직이지 않으므로 현재그대로의 위치들을 append
            new_jombie[ll] = jombie[ll]  # 좀비들의 위치들도 마찬가지로 그대로 유지
            bump.append(ll)
            nomove.remove(ll)  # 한번 실행을 완료했으므로 이 리스트에선 제거 O(N)

        else:  # 정지해야하는 경우가 아니면
            if jombie[ll] < 0:  # 그리고 좀비가 존재하는 곳에서의 id 가 음수값이라면
                if locs[i] - 1 < 0:  # 먼저 왼쪽 절벽으로 떨어지는 경우
                    drop.append(jombie[ll])  # O(1) drop 리스트에 추가
                    new_jombie[ll] = 0  # 그 위치는 이제 좀비가 사라지므로 0으로 변경하고
                    cnt += 1  # 떨어진 횟수에 +1

                else:  # 절벽으로 떨어지지 않는 경우
                    if (locs[i] - 1) in bump:  # 다음 턴에 이동했을때 부딪히는 경우
                        # 이동해야할 위치를 change_index에 저장해두고
                        change_index = locs[i] - 1
                        # 기존에 있던 id를 마이너스로 바꿈 -> 앞으로 다시 진행할 때 방향을 반대로 움직일 수 있도록 함
                        new_jombie[change_index] = (-1) * \
                            (new_jombie[change_index])

                        # 한 인덱스에 두가지 값이 들어갈 수 없으므로 이 다음 턴에 한타임 정지하는대신에, 이번턴에 미리 이동을 마친다

                        if new_jombie[change_index] < 0:  # 바뀐 id 가 음수값이면 앞으로 왼쪽으로 이동해야한다
                            new_jombie[change_index -
                                       1] = new_jombie[change_index]  # 왼쪽으로 이동
                            # 기존위치는 좀비가 이동하고 없으므로 0처리
                            new_jombie[change_index] = 0
                            ch = new_locs.index(change_index)  # O(N) 의 연산으로
                            # 기존에 움직여놨지만 뒤에서 탐색해보았을때 부딪힌 case일때, 기존에 움직인것을 부딪힌거에 맞게 다시 배치해야함
                            new_locs[ch] = change_index - 1
                            # nomove 리스트에 그 위치값을 append 하여 다음턴에 움직이지 않도록 함
                            nomove.append(change_index - 1)

                        else:  # 바뀐 id 가 양수값이면 앞으로 오른쪽으로 이동해야한다
                            new_jombie[change_index +
                                       1] = new_jombie[change_index]  # 오른쪽으로 이동
                            # 기존위치는 좀비가 이동하고 없으므로 0 처리
                            new_jombie[change_index] = 0
                            ch = new_locs.index(change_index)  # O(N) 의 연산으로
                            # 기존에 움직여놨지만 뒤에서 탐색해보았을때 부딪힌 case일때, 기존에 움직인것을 부딪힌거에 맞게 다시 배치해야함
                            new_locs[ch] = change_index + 1
                            # nomove 리스트에 그 위치값을 append 하여 다음턴에 움직이지 않도록 함
                            nomove.append(change_index + 1)
                        # 위의 과정으로 앞에있던 겹친것과 지금 탐색중인 것의 충돌시 문제를 해결

                        # 지금 탐색중인 좀비 id 도 마찬가지로 방향을 바꾸고
                        new_jombie[ll] = jombie[ll] * (-1)
                        new_locs.append(ll)  # 새로운 위치로 append 한다
                        nomove.append(ll)  # 마찬가지로 nomove 리스트에도 추가

                    # 만약 반거리 이동했을때 서로 부딪힌 경우가 가능한 조건이다
                    elif i >= 1 and locs[i] - locs[i-1] == 1:

                        change_index = locs[i-1]  # 그 전 위치값을 change_index 로 했을때
                        if new_jombie[change_index + 1] != 0:  # 그 전에 움직인 값이 위로 움직이던 방향이었으면
                            new_jombie[change_index] = (-1) * \
                                (new_jombie[change_index + 1]
                                 )  # 그 좀비id를 불러와 방향을 바꿔줌
                            new_jombie[change_index + 1] = 0
                        else:  # 그 전에 움직인 값이 아래로 움직이던 방향이었으면
                            new_jombie[change_index] = (-1) * \
                                (new_jombie[change_index - 1]
                                 )  # 그 좀비id를 불러와 방향을 바꿔줌
                            new_jombie[change_index - 1] = 0

                        if new_jombie[change_index] < 0:  # 만약 그 id 가 음수라면
                            # 음수 방향에 맞게 기존에 움직였던 것을 수정해야함 O(N)
                            ch = new_locs.index(change_index + 1)
                            new_locs[ch] = change_index
                            bh = bump.index(change_index + 1)
                            bump[bh] = change_index

                        else:  # 만약 그 id 가 양수라면
                            # 양수 방향에 맞게 기존에 움직였던 것을 수정해야함 O(N)
                            ch = new_locs.index(change_index - 1)
                            new_locs[ch] = change_index
                            bh = bump.index(change_index - 1)
                            bump[bh] = change_index

                        new_jombie[ll] = jombie[ll] * \
                            (-1)  # 현재 탐색중인 좀비도 방향 바꿔주고
                        new_locs.append(ll)  # 그방향을 위치에 그대로 추가
                        bump.append(ll)

                    else:  # 그 외 모든 경우엔 그냥 왼쪽으로 1거리씩 이동
                        new_jombie[ll-1] = jombie[ll]  # 왼쪽으로 좀비 이동
                        jombie[ll] = 0  # 기존 위치는 0으로
                        # 왼쪽으로 한칸 이동한 지점의 좌표를 append
                        new_locs.append(locs[i] - 1)
                        bump.append(locs[i] - 1)  # 이번 턴에 충돌하는 게 있는 지 check

            else:  # 좀비가 존재하는 곳의 id가 양수인 경우
                if locs[i] + 1 > L:  # 오른쪽 절벽으로 떨어지는 경우
                    drop.append(jombie[ll])  # O(1) drop 리스트에 추가
                    new_jombie[ll] = 0
                    cnt += 1  # 떨어지는 횟수 + 1

                else:  # 떨어지지 않는 경우
                    if (locs[i] + 1) in bump:  # 부딪히는 경우

                        change_index = locs[i] + 1
                        # 기존에 있던 걸 마이너스로 바꾸고
                        new_jombie[change_index] = (-1) * \
                            (new_jombie[change_index])

                        # 아래의 과정에 대한 자세한 설명은 위에 "좀비가 존재하는 곳에서의 id 가 음수값이라면 "에서 설명한 내용과 동일함
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

                    elif i >= 1 and locs[i-1] == 1 + locs[i]:  # 반거리에서 겹치는 유일한 조건

                        change_index = locs[i-1]
                        if new_jombie[change_index + 1] != 0:
                            new_jombie[change_index] = (-1) * \
                                (new_jombie[change_index + 1])
                            new_jombie[change_index + 1] = 0
                        else:
                            new_jombie[change_index] = (-1) * \
                                (new_jombie[change_index - 1])
                            new_jombie[change_index - 1] = 0

                        if new_jombie[change_index] < 0:
                            ch = new_locs.index(change_index + 1)
                            new_locs[ch] = change_index
                            bh = bump.index(change_index + 1)
                            bump[bh] = change_index

                        else:
                            ch = new_locs.index(change_index - 1)
                            new_locs[ch] = change_index
                            bh = bump.index(change_index - 1)
                            bump[bh] = change_index

                        new_jombie[ll] = jombie[ll] * (-1)
                        new_locs.append(ll)
                        bump.append(ll)

                    else:  # 그 외의 경우엔 모두 오른쪽으로 1거리 이동
                        new_jombie[ll+1] = jombie[ll]  # 오른쪽으로 좀비 이동
                        jombie[ll] = 0
                        # 오른쪽으로 한칸 이동한 지점의 좌표를 append
                        new_locs.append(locs[i] + 1)
                        bump.append(locs[i] + 1)

    if cnt == 2:  # 떨어지는 횟수가 2번이라면
        for aa in idss:  # 시간복잡도 (O(N))
            if abs(aa) == abs(drop[-2]):  # drop2가 먼저 들어간것
                drop2 = aa  # 원래의 id 값으로 drop 에 바꿔넣어줌 (부호)
            elif abs(aa) == abs(drop[-1]):
                drop1 = aa

        if drop2 > drop1:  # 먼저들어간게 크면
            first = drop2  # 서로 교환해야됨
            second = drop1
            drop[-2] = second
            drop[-1] = first  # 순서 바꿔 넣기

    elif cnt == 1:  # 떨어지는 횟수가 1번이라면
        for a in idss:  # O(N)
            if abs(a) == abs(drop[-1]):  # 원래의 id 값으로 drop 에 바꿔넣어줌 (부호)
                drop[-1] = a

    locs = new_locs
    # 이렇게 진행할 겨우 한바퀴를 다 돌면 locs 은 새로운 위치들로 재배치된다.
    jombie = new_jombie  # 좀비들의 위치와 id를 나타내는 list도 마찬가지로 재배치
    bump = []  # bump 함수는 새롭게 while문을 돌기위해 초기화

print(drop[k-1])  # k번째로 떨어진 값 출력
