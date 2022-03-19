# 구간 최솟값 찾기
'''리스트 A에 저장된 n개의 정수 값에 대해, 길이가 k인 구간(interval)를 왼쪽-> 오른쪽으로 이동하면서 해당구간에 포함도니 값 중 최소 값을 새로운 리스트에 저장'''

# deque를 사용하여 왼쪽 오른쪽에서 모두 삽입, 삭제 가능하게함
# 가장 최악의 경우 O(n^2)까지 가지만, 최적의 경우 O(n) 정도의 시간에 수행됨

import sys
from collections import deque

n, k = map(int, input().split())
A = list(map(int, input().split()))
check = deque(A[:k])  # 검사할 구간 deque 처리 (초기값은 처음부터 k-1 까지)
result = []  # 최종 결과 저장할 리스트
minn = min(list(check))  # 현 리스트의 최소값 -> 시간복잡도 O(k)
result.append(minn)  # O(1) 현 최솟값을 result 에 append(O(1))

for i in range(k, n):  # 그 다음 검사 리스트 순회 O(n-k)
    check.append(A[i])  # 현재 검사리스트에서 새로 하나를 추가하고
    pop = check.popleft()  # 젤 왼쪽에 있는 것은 뺀다 -> 새로운 검사리스트 생성  (O(1)의 시간복잡도)
    if pop == minn:  # 만약 pop 한 값이 현재의 minn값이라면
        minn = min(list(check))  # 새로 min값 찾도록 함 -> 시간복잡도 O(k)
        result.append(minn)  # result 에 추가
    else:
        if A[i] > minn:  # 새로 들어온 값이 minn값 보다 크다면
            result.append(minn)  # 현재 minn 값에는 변화가 없으므로 result 리스트에 그대로 추가
        else:  # 새로 들어온 값이 minn값 보다 작다면
            minn = A[i]  # 새로 들어온 값을 minn값으로 업데이트
            result.append(minn)  # 이 값을 result 에 추가

print(" ".join(map(str, result)))  # result 함수 출력(빈칸 공백)
