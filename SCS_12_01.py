# 합성함수
# 최소 공통 조상 유형 동일

# dp를 이요하여 O(nlogn) 시간에 sparse table 을 만들 수 있음
import sys
input = sys.stdin.readline

log = 14  # 2^k >= MAX(10000) == 13.287... 보다 큰 정수
n = int(input())
func = [0]+list(map(int, input().split()))
dp = [[func[i]] for i in range(n+1)]

# 시간복잡도 : O(nlogn)
for j in range(1, log + 1):
    for i in range(1, n + 1):
        dp[i].append(dp[dp[i][j-1]][j-1])  # dp[i][j] = 정점 i에서 2^j 번 이동한 후의 정점

q = int(input())

# O(qlogn)
for _ in range(q):
    x, k = map(int, input().split())  # f^k(x)
    for b in range(log, -1, -1):
        if k >= 1 << b:  # 2^b보다 크다면
            k -= 1 << b  # 2^b를 제외한 나머지를 계산
            x = dp[x][b]  # 0이 될때까지 반복
    print(x)
