''' 정답 코드
n = int(input())
A = [int(x) for x in input().split()]

A.sort()
m = float("Inf")
for i in range(n):
    if m > A[i] + A[2*n-i-1]:
        m = A[i] + A[2*n-i-1]
print(m)
'''