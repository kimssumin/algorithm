# 행복한 수열의 개수

n, m = map(int, input().split())
num = []
for _ in range(n):
    num.append(list(map(int, input().split())))
answer = 0

if m == 1:
    answer = 2*n
else:
    for i in range(len(num)):
        cnt = 1
        save = num[i][0]
        for j in range(1, len(num)):
            if num[i][j] != save:
                save = num[i][j]
            else:
                cnt += 1
        # print(cnt)
        if cnt >= m:
            answer += 1

    for i in range(len(num)):
        cnt = 1
        save = num[0][i]
        for j in range(1, len(num)):
            if num[j][i] != save:
                save = num[j][i]
            else:
                cnt += 1
        if cnt >= m:
            answer += 1

print(answer)
