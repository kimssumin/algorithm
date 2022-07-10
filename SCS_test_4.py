
#solve sol
def solve(A, k, n): # k x n product-price table, k products and n days
    total = [[float('Inf') for _ in range(n)] for _ in range(1<<k)]
    # total[S][d] = d일까지 부분집합 S에 속한 물건을 조건에 맞게 사는 데 필요한 최소 금액
    for d in range(n):
        total[0][d] = 0
    for x in range(k):
        total[1<<x][0] = A[x][0]

    for d in range(1, n):
        for s in range(1, 1<<k): # bit respresentation for any subset
            total[s][d] = total[s][d-1]
            for x in range(k):
                if s & (1<<x): # x-bit == 1: product x is selected
                    total[s][d] = min(total[s][d], total[s^(1<<x)][d-1] + A[x][d])
    return total[(1<<k)-1][n-1]
    
k, n = [int(x) for x in input().split()]
A = [[int(x) for x in input().split()] for _ in range(k)]
print(solve(A, k, n))

