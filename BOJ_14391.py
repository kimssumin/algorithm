#종이조각
#brute force
#비트마스크 익히기 !!

n,m = map(int, input().split())
a = []

for _ in range(n):
    a.append(list(input()))

ans = 0
for b in range(1 << n * m):
    sum = 0
    for i in range(n):
        line_sum = 0
        for j in range(m):
            k = i * m + j
            if b & (1 << k): #비트연산자 &(and), <<(left shift)
                sum += line_sum
                line_sum = 0
            else:
                line_sum = line_sum * 10 + int(a[i][j])
        sum += line_sum

    for j in range(m):
        line_sum = 0
        for i in range(n):
            k = i * m + j
            if b & (1 << k):
                line_sum = line_sum * 10 + int(a[i][j])
            else:
                sum += line_sum
                line_sum = 0
        sum += line_sum
    ans = max(ans, sum)
print(ans)

