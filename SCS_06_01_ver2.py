# 좀비월드
# -n부터 n까지의 정수 아이디를 가진 좀비 n명이 절벽으로 떨어지는 k 번째 좀비 찾기

# 좀비의 id 는 절대 바뀌지 않고, 부딪히는 경우와 부딪히지 않는 경우로 나누어 코드 구성
# 부딪히는 경우에도, id 만 다를뿐 전체적인 떨어지는 시간은 동일
# deque 사용
# 시간복잡도는 O(N)


import sys
import functools
from collections import deque


def drop(x, y):  # drop 되는 순서를 결정
    # 전부 O(1)의 시간
    if x[0] > y[0]:
        return 1
    elif x[0] < y[0]:
        return -1
    else:  # 동시에 떨어질 경우에는 id 비교
        if x[1] > y[1]:
            return 1
        elif x[1] < y[1]:
            return -1
        else:
            return 0

# id 가 양수이면 오른쪽 절벽끝과 현재 위치와의 거리를 정렬, id 가 음수이면 왼쪽 절벽끝과 현재 위치와의 거리를 정렬하면 좀비가 떨어질때까지 거리를 알수있음


input = sys.stdin.readline
n, l, k = map(int, input().split())

jombie = deque()  # deque를 이용해 양끝에서 pop 될 수 있도록 함
bump = []  # 만약 부딪힌다면 drop 되는 과정을 저장할 리스트
nobump = []  # 부딪히지 않는다면 drop 되는 과정을 저장할 리스트


cnt = 0
for _ in range(n):  # O(N)
    loc, id = map(float, sys.stdin.readline().split())  # 위치와 id 값을 입력받고
    jombie.append([loc, id])  # 각각의 초기리스트에 2차원 배열형태로 append 한다
    nobump.append([loc, id])  # O(1)의 시간복잡도로 append

# 부딪히지 않는 경우, id 와 상관없이 좀비가 떨어지는 시간과 방향은 변함이 없음
for i in range(n):  # O(N)
    if nobump[i][1] > 0:
        nobump[i][0] = l - nobump[i][0]  # l 과 현재위치와의 거리

# 떨어지는 순서를 고려하여 정렬 (drop 이라는 함수를 위에서 선언해, 떨어지는 조건을 충족하도록 함)
nobump.sort(key=functools.cmp_to_key(drop))

while jombie:  # O(n)의 시간복잡도
    if cnt != n - 1 and nobump[cnt][0] == nobump[cnt + 1][0]:  # 두 좀비가 동시에 떨어진다면
        if jombie[0][1] < jombie[-1][1]:   # 만일 왼쪽 좀비가 - 라면
            bump.append(jombie.popleft())  # 왼쪽 좀비가 더 작은 id 이므로 먼저 떨어진다
            bump.append(jombie.pop())  # 전부 O(1)의 시간복잡도

        else:  # 만일 오른쪽 좀비가 - 라면
            bump.append(jombie.pop())  # 오른쪽 좀비가 더 작은 id 이므로 먼저 떨어진다
            bump.append(jombie.popleft())
        cnt += 2  # 두 좀비가 떨어졌으므로 cnt += 2

    else:  # 동시에 떨어지는 경우가 아니라면
        if nobump[cnt][1] < 0:  # 음수 id 인 경우 왼쪽으로 이동하므로
            bump.append(jombie.popleft())  # 왼쪽부터 떨어진다
        else:  # 양수 id 인경우 오른쪽으로 이동하므로
            bump.append(jombie.pop())  # 오른쪽부터 떨어진다
        cnt += 1  # 한명의 좀비씩 떨어짐

print(int(bump[k - 1][1]))  # k번째 좀비의 id 출력 (int 로 감싸 float으로 입력받았던 것을 정수로 출력함)
