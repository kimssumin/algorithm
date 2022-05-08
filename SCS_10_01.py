# 투포인터 알고리즘, dp 사용
# 시간복잡도  O(NlogN) 시간 안에 해결 가능 -> sort

n, k = map(int, input().split())
color = []
for _ in range(n):  # 시간복잡도 O(N)
    i = int(input())
    color.append(i)  # 점 집합의 색을 나타내는 배열

# 전체적으로는 투포인터 알고리즘(i, j == 시작index, 끝index)을 이용하여 color[i; j+1]이 모든 종류를 포함하면 dp(i+1, j)와 dp(i, j-1)을 호출해 구간을 줄이는데, 이때 모든 색을 포함안하면 더이상 호출하지않도록함
# dp[i , j] = {색의 번호 : 그 색의 수}로 함
'''
ex) color = [1, 2, 1,2] -> dp[0][0] = ps = {1 : 1} -> len(ps) != k
													 dp[0][1] = ps = {1 : 1, 2: 1} -> len(ps) == k
													 ...
												=> 다음 규칙에 따라 len(ps) != k 인 경우 dp[i][j]에서 dp[i][j+1]로 이동
													 len(ps) == k 인 경우 dp[i+1][j]로 이동
'''
ps = {color[0]: 1}  # ps = {첫번째 색의 값, 갯수}
move = (0, 0)  # 초기값
answer = []

while move:
    start, end = move
    if len(ps) == k:  # O(1)
        # answer = [index + 1, 끝index + 1, end - start]
        answer.append([start + 1, end + 1, end - start])
    if start <= end:  # 시작index <= 끝 index
        if len(ps) != k and end + 1 < n:  # 위의 규칙에 따라 끝 index 가 n을 넘지않고, ps set이 k개를 다 가지고있지않으면
            start, end = start, end + 1  # dp[i][j+1]을 호출
        # ps 에 j+1 번째 값 추가
            if color[end] in ps:  # 추가한 end 값이 set 에 있으면
                ps[color[end]] += 1
            else:  # 아니면
                ps[color[end]] = 1  # 새로 추가
            move = (start, end)

        else:
            # ps 에 i번쨰 성분 제거
            if color[start] in ps:
                ps[color[start]] -= 1  # dp[i+1][j] = ps
            if ps[color[start]] == 0:
                ps.pop(color[start])
            move = (start + 1, end)  # 다음 move를 (i+1, j)로 설정
    else:
        break

answer.sort(key=lambda x: (x[2], x[0]))  # x[2]와 x[0]기준 정렬
# O(NlogN) 의 시간복잡도

answer_length = 0

# 최악의 경우에도 O(answer)만큼의 시간복잡도
for i in range(len(answer)):  # 무지개가 발생하는 가장 작은 쌍의 무지개길이부터 탐색했을때 여집합도 만족하는 최소의 경우
    p_ = color[: (answer[i][0])] + color[answer[i][1]:]  # p'에 속하지 않는 점들이 list
    # print(p_)
    if len(set(p_)) == k:  # 여집합도 k개의 색 종류가 있어야함
        answer_length = answer[i][2] + 1
        break

print(answer_length)
