# 땅따먹기

# 이익많게
# dp

from collections import deque

ans_line = []
ans = []
n, k = map(int, input().split())
ground = []
for i in range(n):
    ground.append(list(map(int, input().split())))

if k > (n // 3) * n:
    print(-1)
else:
    for i in ground:
        start = 0
        ans_line.append(i[start] + i[start+1] + i[start+2])
        for j in range(1, n-2):
            start += 1
            if ans_line[-1] >= (i[start] + i[start+1] + i[start+2]):
                continue
            else:
                ans_line.pop()
                ans_line.append((i[start] + i[start+1] + i[start+2]))
        ans.append(ans_line[-1])

    ans.sort()
    end = len(ans)
    answer = 0
    for _ in range(k):
        end -= 1
        answer += ans[end]
    print(answer)
