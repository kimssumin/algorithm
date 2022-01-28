#이전 순열
#brute force

import sys
input = sys.stdin.readline
n = int(input())
seq = list(map(int, input().split()))

#1. k의 최댓값 찾기
k = -1
for i in range(len(seq)-1):
    if seq[i] > seq[i+1]:
        k = i

if k == -1: #오름차순인 경우
    print(-1)

else:
    #2. m의 최댓값 구하기
    for j in range(k+1, len(seq)):
        if seq[j] < seq[k]:
            m = j

    #3. k와 m의 값 바꿔치기
    seq[k], seq[m] = seq[m], seq[k]

    #4. k이후의 값들 내림차순 정렬
    tmp = seq[k+1:]
    tmp.sort(reverse= True)
    result = seq[:k+1] + tmp
    for num in result:
        print(num, end = ' ')
    print()

#10972와 유사
