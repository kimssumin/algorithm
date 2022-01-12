#1로만들기
#Dynamic Programming

N = int(input())

d = [0]*(N+1)
for i in range(2, N+1):
    d[i] = d[i-1] + 1
    if i % 3 ==0:
        d[i] = min(d[i], d[i//3] + 1) # 1을 더하는 이유는 d가 결과가 아닌 계산 횟수를 저장하는 것
    if i % 2 == 0:
        d[i] = min(d[i], d[i//2] + 1)

print(d[N])