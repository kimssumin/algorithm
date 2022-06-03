# 합성함수
# 최소 공통 조상 유형 동일

n = int(input())
func = [0]
for _ in range(n):
    func.append(int(input()))

q = int(input())
for _ in range(q):
    x, k = map(int, input().split())
