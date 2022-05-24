# 땅따먹기

# 이익많게
# dp

# O(n^2)의 시간복잡도


ans_line = []
ans = []
n, k = map(int, input().split())
ground = []
for i in range(n):
    ground.append(list(map(int, input().split())))

if k > (n // 3) * n:  # 타일을 놓을 수 있는 최대 갯수보다 k 가 큰 경우 다 놓을 수 없으므로 -1 출력
    print(-1)
else:
    # O(n ^2)의 시간복잡도
    for i in ground:
        start = 0
        ans_line.append(i[start] + i[start+1] + i[start+2])  # 초기 상태
        for j in range(1, n-2):
            start += 1
            if ans_line[-1] >= (i[start] + i[start+1] + i[start+2]):
                continue
            else:
                ans_line.pop()
                # 그 행에서 가장 큰 3개를 넣음
                ans_line.append((i[start] + i[start+1] + i[start+2]))
        ans.append(ans_line[-1])  # 그 행들을 모으면 전체 타일에서 놓을 수 있는 최대의 수

    ans.sort()  # O(nlogn)
    end = len(ans)
    answer = 0
    for _ in range(k):  # O(k)
        if end != 0:
            end -= 1
            answer += ans[end]  # k개의 수만큼 큰 순으로 내림차순으로 고르면 최대값
    print(answer)


# elif n >= 6: # 한행에 두개 들어가는..
#     cnt = n // 3
#     for i in ground:
#         start = 0
#         ans_line.append(i[start] + i[start+1] + i[start+2])
#         for _ in range(cnt):
#             for j in range(1, n-2):
#                 start += 1
#                 if (ans_line[-1] >= (i[start] + i[start+1] + i[start+2])) and (start + 2 <= n-1):
#                     continue
#                 elif (start + 2 <= n-1) and (ans_line[-1] < (i[start] + i[start+1] + i[start+2])):
#                     ans_line.pop()
#                     ans_line.append((i[start] + i[start+1] + i[start+2]))
#             ans.append(ans_line[-1])
#             start = start + 2
#     ans.sort()
#     end = len(ans)
#     answer = 0
#     for _ in range(k):
#         if end != 0:  # 여기서 runtime error 가 없어진 걸 보면 end == 0인게 있다 -> 예외설정제대로 못했다
#             end -= 1
#             answer += ans[end]
#     print(answer)
