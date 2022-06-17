# 시장선거
# 과반수 시장 당선자 후보자 번호 출력, 없다면 -1 출력

import sys
input = sys.stdin.readline

n = int(input())
standard = n/2  # 과반수의 기준이 되는 수 저장 (O(1))
candidate = list(map(int, input().split()))
candidate.sort()  # O(NlogN)
check = [0]  # candidate의 첫번쨰 인덱스 0 을 기본값으로 넣음

for i in range(1, n):  # candidate 리스트를 돌면서 전 리스트 요소와 값이 달라지는 경우에 check 리스트에 그 index를 append -> 시간복잡도(O(n))
    if candidate[i] != candidate[i-1]:
        check.append(i)  # O(1)
check.append(n)  # 마지막에 리스트 길이만큼 append 함
# print(check)

for j in range(1, len(check)):  # O(len(check)) 만큼의 시간복잡도
    print1 = False  # -1을 출력해야하는지 체크하는 용도
    if check[j] - check[j-1] < standard:  # check 리스트의 요소들간의 차이가 득표수인데
        print1 = True  # 마지막까지도 True 이면 -1 출력
        pass  # 이것이 과반수보다 작다면 패스
    else:
        print(candidate[check[j]-1])  # check[j]는 과반수후보자 다음 후보자 인덱스이므로 -1해줘야함
        break

if print1 == True:
    print(-1)  # 마지막까지도 True이면 -1 출력
