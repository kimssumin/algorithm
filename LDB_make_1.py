#이동빈 저, 이것이 코딩테스트다 문제 중
#1이 될때까지, 그리디 알고리즘

N, K = map(int, input().split())
cnt = 0

while N >= K:
    while N % K != 0 :
        N = N-1
        cnt += 1

    N = N / K
    cnt += 1

while N > 1:
    N = N-1
    cnt += 1

print(cnt)