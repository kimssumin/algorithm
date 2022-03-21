# 두 여왕
# 체스보드에 놓을 수 있는 방법의 수
# bruteforce, back tracking
# 시간복잡도 : O(n^3) 로 추정됨

n = int(input())

ans = 0  # 최종정답 변수


def checking(x):  # 대각선과 상하좌우 검사하는 함수
    if x == 0:  # 첫번째 행은 일단 통과 시킴 (어떻게든 하나의 기준점은 잡히기 때문이다)
        return True
    for i in range(x):  # O(x) 의 시간복잡도
        # 연산은 모두 O(1)의 시간이고
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            # row[x] == row[i] 는 같은 열에 또 존재하는지를 체크하는 것이며, abs 식은 왼쪽 위 대각선과 오른쪽 위 대각선에 Q가 있는지 검사하는 것이다
            return False  # 있으면 두면 안되므로 False

    return True  # 검사를 통과하면 True


def n_queens(x):  # 경우의 수를 찾는 함수
    global ans  # ans 전역변수 설정
    if x == 2*i + (a * 1):  # Q가 두번 놓이면
        ans += 1  # 경우의 수 (최종정답) + 1 (시간복잡도 O(1))

    else:  # 아니면 for 문을 반복하는데
        for j in range(n):  # 행에서 오른쪽으로 이동하면서
            row[x] = j  # [x, j]에 Q를 놓겠다는 의미이다
            if checking(x):  # 상하좌우, 대각선을 검사하고 통과한다면
                # x , 즉 다음 줄(이 때 다음줄은 x+i로 설정하여 n행까지 checking 하도록하였다)로 넘어갈 수 있다. (재귀함수 이용)
                n_queens(x+i)


for a in range(0, n-1):  # a는 row 배열에서 start 위치이고,
    for i in range(1, n-a):  # i 는 row 배열에서 end 위치이다.
        # 이 이중 for 문은 O(n^2) 의 시간이 소요된다
        # Q가 들어가는 index 를 저장하는 배열로 1차원 배열로 시간복잡도를 절약했으며, row[i] = j 이면 [i, j]위치에 Q가 저장되어있음을 나타낸다
        row = [100] * n
        # 초기값을 100으로 설정한 이유는, 테스트케이스 검사를 할 때 배열에 0으로 값이 들어가는 것과 구분하기 위함
        # a, 즉 0번째 행부터 시작하여 n-2행 까지 반복한다 (index 상 n-2 가 가장 마지막 경우의 수이기 떄문)
        n_queens(a)


print(ans)  # 최종 정답을 출력한다
