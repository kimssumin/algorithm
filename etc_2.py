answer_list = (["3+2", 5, 3], ["6/2", 3, 5], ["10-2", 8, 3],
               ["2의 3승", 8, 4], ["5-2*2", 1, 5])
score = 0
cnt = 0

for i in range(len(answer_list)):
    num = int(input(answer_list[i][0] + " : "))
    if num == answer_list[i][1]:
        score += answer_list[i][2]
        cnt += 1

print("정답수 :", cnt)
print("오답수 :", 5-cnt)
print("점수 :", score)
