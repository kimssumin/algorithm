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
check = []
cnt = 0  # 경우의 수 count

for i in range(0, n-2):
    a_index = i
    for j in range(i+2, n):
        c_index = j
        a = num[i]
        c = num[j]
        if (2*a + c) % 3 == 0:
            x = ((2*a + c) // 3)
        else:
            x = ((2*a + c) // 3) + 1  # x 이상의 정수
        y = ((a + c) // 2)  # y 이하의 정수

        if num[i+1] >= x and num[j-1] <= y:
            cnt += j-i-1
            #check.append([1, cnt])
        elif num[i+1] < x and num[j-1] <= y:
            k = 0
            while num[i+1+k] < x:
                k += 1
            cnt += j-i-k-1
            #check.append([2, cnt])
        elif num[i+1] >= x and num[j-1] > y:
            k = 0
            while num[j-1-k] > y:
                k += 1
            cnt += j-k-i-1
            #check.append([3, cnt])
        else:
            k = 0
            while num[i+1+k] < x and num[j-1-k] > y:
                k += 1
            if num[i+1+k] >= x and num[j-1-k] <= y:
                cnt += j-i-1-k-k
                #check.append([4, cnt])
            elif num[i+1+k] < x and num[j-1-k] <= y:
                l = 0
                while num[i+1+k+l] < x:
                    l += 1
                cnt += j-k-k-i-l-1
                #check.append([5, cnt])
            elif num[i+1+k] >= x and num[j-1-k] > y:
                l = 0
                while num[j-1-k-l] > y:
                    l += 1
                cnt += j-k-k-i-l-1
                #check.append([6, cnt])


print(cnt)
# print(check)
