# 투포인터 알고리즘 이용
#시간복잡도 : O(N)
# 리스트 이용

import sys

input = sys.stdin.readline
n = int(input())  # n의 값 입력
A = list(map(int, input().split()))  # A 리스트 입력
B = [0]  # 젤 첫번째 값은 무조건 0 이므로 미리 할당하고 시작

right = 1  # A의 두번쨰 index 부터 탐색 시작하므로 1 로 설정
left = right - 1  # 가장 인접한 값이므로 가장 가까운 값부터 탐색
# 무의미한 반복을 피하기 위해 min 값 설정 -> min값이면 그 전 인덱스에서 자기보다 작은 값은 없을테니 바로 0을 추가하도록 함 (초기값은 리스트의 첫번째 값으로 설정)
minn = A[0]
# 연산의 시간복잡도는 O(1)

while left < right and right < n:  # left 값은 right 값보다 항상 작으면서 right 가 리스트 끝까지 갈때
    if A[left] < A[right]:  # 왼쪽에 있는 요소가 오른쪽보다 작다면
        B.append(A[left])  # B에 그 값을 추가한다 (시간복잡도 O(1))
        right += 1  # 다음요소로 넘어가고
        left = right - 1  # 다음요소의 하나 작은 인덱스로 새로 할당해서 새로 탐색을 시작

    # 현재 요소가 minn값 보다 작으면 (리스트의 왼쪽부터 지금까지 중에 가장 작은 값이므로)
    elif A[right] <= minn:
        B.append(0)  # 조건에 맞는 경우가 없을테니 바로 0 을 출력
        minn = A[right]  # minn값 새로 업데이트
        right += 1  # 다음 요소로 넘어가고
        left = right - 1  # 다음요소의 하나 작은 인덱스로 새로 할당해서 새로 탐색을 시작

    else:  # 왼쪽에 있는 요소가 오른쪽보다 크거나 같다면
        if left - 1 >= 0:  # left 값이 0 이하가 되지 않는 한에서
            left -= 1  # 하나씩 왼쪽으로 이동하면서 조건에 맞도록 탐색

        elif left == 0:  # left 값이 리스트 시작값까지 갔을때에도 조건을 만족하지않을때
            B.append(0)  # 0을 추가하고 (시간복잡도 O(1))
            right += 1  # 다음 요소로 넘어간다
            left = right - 1  # 마찬가지로 다음요소의 하나 작은 인덱스로 새로 할당해서 새로 탐색을 시작

print(" ".join(map(str, B)))  # 한줄에 빈칸을 띄어쓰기로 해 출력하도록함
