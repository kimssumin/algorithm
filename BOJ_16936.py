# 나3 곱2
# bruteforce

n = int(input())
b = list(map(int, input().split()))

# 첫번째 수는 가장 큰 3^n을 약수로 갖는 수들 중 가장 작은 수
a = []

for num in b:
    can3 = 0
    num_origin = num
    while True:
        if num % 3 == 0:
            can3 += 1
            num //= 3
        else:
            break
    a.append([can3, num_origin])

a.sort(key=lambda x: (-x[0], x[1]))
for i in range(n):
    print(a[i][1], end=' ')
