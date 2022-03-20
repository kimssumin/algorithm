# 시장선거
# 과반수 시장 당선자 후보자 번호 출력, 없다면 -1

import sys
input = sys.stdin.readline

n = int(input())
standard = n/2  # 과반수의 기준이 되는 수 저장 (O(1))
candidate = list(map(int, input().split()))
candidate.sort()  # O(NlogN)
check = [0]  # candidate의 첫번쨰 인덱스 0 을 기본값으로 넣음

for i in range(1, n):
    if candidate[i] != candidate[i-1]:
        check.append(i)
print(check)

for j in range(1, len(check)):
    if check[j] - check[j-1] < standard:
        pass
    else:
        print(candidate[check[j]-1])
