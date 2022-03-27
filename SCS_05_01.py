# 일반적인 for문을 이용해 앞 리스트요소부터 search 하면 만약 리스트 뒷부분에 rotation start 지점이 있다면 앞 부분을 도는데 비교연산 횟수가 낭비된다. 반을 나눠탐색하면 리스트 뒷부분에 rotation start 지점이 있다면 앞의 반부분을 도느라 낭비하는 시간을 줄일 수 있음 (비교연산 횟수를 줄임)
# 이분탐색 방법 활용
# 최악의 경우 O(n)

import sys

A = list(map(int, input().split()))  # rotation 이 된(혹은 안된) 리스트 A 입력

find1 = len(A) // 2  # 입력받은 A 를 앞/뒷 부분으로 나눈다 (O(1))
a = False  # 뒷부분에서 값이 나오면 앞부분은 살펴볼 필요가 없다

for i in range(find1, len(A)):  # 반을 기준으로 뒷부분을 탐색함(O(n/2))
    if A[i] <= A[i-1]:  # 전 요소 보다 값이 작으면
        k = i  # 그 지점부터 rotation 이 시작된 것이므로
        print(len(A) - k)  # 전체 길이에서 index number를 빼준 값이 rotation 횟수
        break  # 찾았으므로 반복문 종료
        # 시간복잡도 (뒷부분에서 발견이 될 경우에 최악의 경우는 O(n/2))
    if i == len(A) - 1:  # 하지만 뒷부분에서도 발견이 되지않으면 앞부분에 있다는 말이므로
        a = True  # 앞부분을 찾아봐야한다

if a == True:  # 앞부분을 찾아봐야한다면
    for j in range(1, find1):  # 최악의 경우 또 O(n/2)
        if A[j] <= A[j-1]:  # 전 요소보다 값이 작으면
            k = j  # 그 지점부터 rotation 이 시작된 것이므로
            print(len(A) - k)  # 전체 길이에서 index number를 빼준 값이 rotation 횟수
            break  # 찾았으면 반복문 종료

        # 위에서 이어 O(n/2)+O(n/2)로 O(n)의 시간복잡도(전체경우에서 제일 최악의 case)
        if j == find1 - 1:
            print(0)  # rotation 된 것이 없는 것이므로 0 출력
