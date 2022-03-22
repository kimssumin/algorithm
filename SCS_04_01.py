
import sys
n = int(input())
num = []
start = 0
end = n-1

input = sys.stdin.readline

for _ in range(n):  # 정수 입력을 받음
    num.append(int(input()))  # O(n)
num.sort()

cnt = 0
c_n = end
c = num[c_n]


def setting(i, start):
    global a
    global b
    b = num[i]
    a = num[start]


def checking(a, b, c):
    if 2*b - a <= c <= 3*b - 2*a:
        return True
    else:
        return False


for i in range(n-2, -1, -1):
    start = i-1
    setting(i, start)

    if checking:  # 조건을 만족하면
        cnt += start + 1  # a가 더 작아지는 경우는 모두 통과
    else:  # 조건을 만족하지 않으면
        while checking == False:
            start -= 1
            setting(i, start)

    while start < i and start < end:
        a = num[start]
        li = 3*b - 2*a
        c_n = i+1
        c = num[c_n]
        while li < c:
            c_n += 1
            c = num[c_n]
