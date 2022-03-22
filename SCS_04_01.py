#(딩, 동, 댕)
# n개의 서로 다른 정수값들 중 a,b,c 세 값이 두 조건을 만족하는 쌍의 개수 구하기
# a<b<c && b-a <= c-b <= 2*(b-a)

import sys
n = int(input())
num = []  # 정수 입력을 받을 리스트 선언

input = sys.stdin.readline

for _ in range(n):  # 정수 입력을 받음
    num.append(int(input()))  # O(n)
num.sort()  # O(nlogn) -> 첫번째 조건인 a<b<c를 만족하기 위함

cnt = 0  # 경우의 수 count


def setting(i, start):  # a, b를 설정하는 함수
    global a
    global b
    b = num[i]  # 바로 선언하는 것이기 때문에 O(1)의 시간복잡도
    a = num[start]  # 바로 선언하는 것이기 때문에 O(1)의 시간복잡도


def checking(a, b, c):  # 주어진 두번째 조건이 맞는지 체크하는 함수
    if (2*b - a) <= c and c <= ((3*b) - (2*a)):  # 조건을 만족한다면
        return True  # True 반환
    else:
        return False  # 조건 만족하지 않으면 False 반환


for j in range(n-1, 1, -1):  # c 값의 변화 for 문 (가장 끝 인덱스값에서 앞에서 세번째 인덱스 까지 감소 가능) #O(n)
    c_n = j  # C 의 index
    c = num[c_n]  # c 의 값
    for i in range(j-1, 0, -1):  # b 값의 변화 for 문 (c 값 하나 아래 값부터 앞에서 두번째 인덱스 까지 감소가능) #O(n)
        start = i-1  # b의 index 값 설정
        setting(i, start)  # b의 index를 바꾼 후 새로 a, b 설정

        # if checking:  # 조건을 만족하면
        if checking(a, b, c):
            cnt += 1  # 경우의 수 하나 추가
            while start > 0:  # a 값의 변화
                start -= 1  # a 값의 index 가 하나씩 아래로 변화하면서
                setting(i, start)  # a, b값이 바뀌고
                if checking(a, b, c):
                    cnt += 1  # 조건을 만족하면 cnt += 1

        else:  # 조건을 만족하지 않으면
            while start > 0:  # a값을 하나씩 아래로 내리며 조건을 만족하는지 check
                start -= 1  # a값의 index는 하나씩 아래로 변화하면서
                setting(i, start)  # a, b값이 바뀌고
                if checking(a, b, c):
                    cnt += 1  # 조건을 만족하면 cnt += 1

print(cnt)


'''
Time out 되지만 확인할 수 있는 코드
from itertools import combinations as com
import sys
n = int(input())
num = []

input = sys.stdin.readline

for _ in range(n):  # 정수 입력을 받음
    num.append(int(input()))  # O(n)
num.sort()
cnt = 0
for i in com(num, 3):
  a = int(list(i)[0])
  b = int(list(i)[1])
  c = int(list(i)[2])
  if c - b <= 2*(b-a):
            if 2*b - a <= c:
              cnt += 1
              print(a,b,c)
print(cnt)
'''