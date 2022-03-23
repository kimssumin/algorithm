#(딩, 동, 댕)
# n개의 서로 다른 정수값들 중 a,b,c 세 값이 두 조건을 만족하는 쌍의 개수 구하기
# a<b<c && b-a <= c-b <= 2*(b-a)

from itertools import combinations as com
import sys
n = int(input())
num = []  # 정수 입력을 받을 리스트 선언

input = sys.stdin.readline

for _ in range(n):  # 정수 입력을 받음
    num.append(int(input()))  # O(n)

num.sort()  # O(nlogn) -> 첫번째 조건인 a<b<c를 만족하기 위함
#check = []
cnt = 0  # 경우의 수 count


# a, c 기준으로 식을 재정렬하여 (2a + c) / 3 <= b <= (a+c) / 2 를 바탕으로 b를 구하는 방식
nl = [i for i in range(n)]

for i in com(nl, 2):
    a_index = int(list(i)[0])
    c_index = int(list(i)[1])
    if c_index - a_index == 1:
        pass
    else:
        a = num[a_index]  # a 에 해당 num 할당 (O(1))
        c = num[c_index]  # c 에 해당 num 할당 (O(1))
        if (2*a + c) % 3 == 0:  # O(1) 조건 중 (2a + c) / 3 <= b 를 만족하는걸 확인하기 위해 기준점을 설정
            # 소수점이 나오면 무조건 올림을 해야하고(정수로), 정수이면 그대로 반환해야 하므로 if -else 문 활용
            x = ((2*a + c) // 3)
        else:
            x = ((2*a + c) // 3) + 1  # x 이상의 정수
        y = ((a + c) // 2)  # y 이하의 정수 - (b <= (a+c) / 2) 만족 위함

        # a index 하나 뒤의 원소와 c의 index 하나 밑의 원소가 조건을 모두 만족하면
        if num[a_index+1] >= x and num[c_index-1] <= y:
            # 그 안에 있는 b들은 모두 값을 만족할 것이므로 구간길이를 연산해 cnt 에 합 (O(1))
            cnt += c_index-a_index-1
            #check.append([1, cnt])
        # a index 하나 뒤의 원소는 조건을 만족하지 않는데 c의 index 하나 밑의 원소는 조건을 만족하면
        elif num[a_index+1] < x and num[c_index-1] <= y:
            k = 0
            # b index 첫값을 하나씩 증가시켜 조건을 만족하기 시작하는 수를 찾고 (최악의 경우 O(n-3)까지 시간복잡도)
            while num[a_index+1+k] < x:
                k += 1
            cnt += c_index-a_index-k-1  # 위와 마찬가지로 구간 길이를 연산해 cnt 에 합 (O(1))
            #check.append([2, cnt])

        # a index 하나 뒤의 원소는 조건을 만족하는데 c의 index 하나 밑의 원소는 조건을 만족하지않는다면
        elif num[a_index+1] >= x and num[c_index-1] > y:
            k = 0
            # b index 끝값을 하나씩 감소시켜 조건을 만족하기 시작하는 수를 찾고 (최악의 경우 O(n-3)까지 시간복잡도)
            while num[c_index-1-k] > y:
                k += 1
            cnt += c_index-k-a_index-1  # 위와 마찬가지로 구간 길이를 연산해 cnt 에 합 (O(1))
            #check.append([3, cnt])
        else:  # 두 원소 다 만족하지 않는다면
            k = 0
            # 일단 하나라도 만족할 때까지 감소 (최악의 경우 O(n/2) 까지 시간복잡도)
            while num[a_index+1+k] < x and num[c_index-1-k] > y:
                k += 1
            if num[a_index+1+k] >= x and num[c_index-1-k] <= y:  # 다시 위의 과정을 반복
                cnt += c_index-a_index-1-k-k
                #check.append([4, cnt])
            elif num[a_index+1+k] < x and num[c_index-1-k] <= y:
                l = 0
                while num[a_index+1+k+l] < x:
                    l += 1
                cnt += c_index-k-k-a_index-l-1
                #check.append([5, cnt])
            elif num[a_index+1+k] >= x and num[c_index-1-k] > y:
                l = 0
                while num[c_index-1-k-l] > y:
                    l += 1
                cnt += c_index-k-k-a_index-l-1
                #check.append([6, cnt])

print(cnt)
