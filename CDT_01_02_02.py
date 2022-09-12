# 삼각형 컨베이어벨트
# simulation

# 변수 선언 및 입력
n, t = tuple(map(int, input().split()))
u = list(map(int, input().split()))
d = list(map(int, input().split()))
r = list(map(int, input().split()))

for _ in range(t):

    # 주어진 배열을 오른쪽으로 한칸 shift
    temp = u[n - 1]
    for i in range(n - 1, 0, -1):
        u[i] = u[i - 1]
    u[0] = r[n - 1]

    temp2 = d[n - 1]
    for i in range(n - 1, 0, -1):
        d[i] = d[i - 1]
    d[0] = temp  # temp를 1번째 원소에 기록

    for i in range(n - 1, 0, -1):
        r[i] = r[i - 1]
    r[0] = temp2  # temp를 1번째 원소에 기록

# 출력
for elem in u:
    print(elem, end=" ")
print()

for elem in d:
    print(elem, end=" ")

print()

for elem in r:
    print(elem, end=" ")
