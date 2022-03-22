
import sys
n = int(input())
num = []

input = sys.stdin.readline

for _ in range(n):  # 정수 입력을 받음
    num.append(int(input()))  # O(n)
num.sort()

cnt = 0
ans = []


def setting(i, start):
    global a
    global b
    b = num[i]
    a = num[start]


def checking(a, b, c):
    if (2*b - a) <= c and c <= ((3*b) - (2*a)):
        return True
    else:
        return False


for j in range(n-1, 1, -1):
    end = j
    c_n = end
    c = num[c_n]
    for i in range(j-1, 0, -1):
        start = i-1
        setting(i, start)

        # if checking:  # 조건을 만족하면
        if checking(a, b, c):
            cnt += 1  # a가 더 작아지는 경우는 모두 통과
            ans.append([a, b, c])
            while start > 0:  # checking == False and
                start -= 1
                setting(i, start)
                if checking(a, b, c):
                    cnt += 1
                    ans.append([a, b, c])
                    # break

        else:  # 조건을 만족하지 않으면
            while start > 0:  # checking == False and
                start -= 1
                setting(i, start)
                if checking(a, b, c):
                    cnt += 1
                    ans.append([a, b, c])
                    break


print(cnt)
print(sorted(ans))

# while start < i and start < end:
#     a = num[start]
#     li = 3*b - 2*a
#     c_n = i+1
#     c = num[c_n]
#     while li < c:
#         c_n += 1
#         c = num[c_n]
