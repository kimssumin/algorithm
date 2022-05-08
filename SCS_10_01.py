n, k = map(int, input().split())
color = []
for _ in range(n):
	i = int(input())
	color.push(i)

ps = {color[0] : 1} #첫번째 색의 값, 갯수
move = (0, 0)
answer = []
while move:
	start, end = move
	if len(ps) == k :
		answer.append([start + 1, end + 1, end - start]) #[시작index + 1, 끝index + 1, end - start]
