
import sys
n = int(input())
num = []
start = 0
end = n-1

input = sys.stdin.readline

for _ in range(n):  # 정수 입력을 받음
    num.append(int(input()))  # O(n)
num.sort()
for i in range(1, n-1):
    b = num[i]
    while start < i and start < end:
        a = num[start]
        li = 3*b - 2*a
        c_n = i+1
        c = num[c_n]
        while li < c:
            c_n += 1
            c = num[c_n]
