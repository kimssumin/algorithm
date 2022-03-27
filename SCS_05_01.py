# 리스트 값을 오름차순으로 정렬한 후 왼쪽방향으로 몇번 rotation 이동
import sys

A = list(map(int, input().split()))

find1 = len(A) // 2
for i in range(1, find1):
    if A[i] < A[i-1]:
        k = i
        print(k)
        break
    else:
        k = -1
        pass

if k == -1:
    for j in range(find1, len(A)+1):
        if A[i] < A[i-1]:
            k = i
            print(k)
            break
        else:
            pass

    print(0)
