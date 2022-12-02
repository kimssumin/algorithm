def calcScore(arr):
    score = 0
    for s ,idx in enumerate(arr):
            if s != 0:
                score += (10-idx)
    return score

def solution(n, info):
    score = [10-i for i in range(10)]
    ryanscore = 0
    save_answer = []
    check = False
    for i in range(10):
        peachscore = calcScore(info)
        cnt = n
        answer = []
        answer.extend([0 for _ in range(i)])
        for j in range(i, 10):
            if cnt > 0 and info[j] + 1 >= n:
                peachscore -= score[j]
                answer.append(info[j] + 1)
                cnt -= info[j] + 1
        if peachscore < calcScore(answer):
            if (ryanscore < calcScore(answer)):
                ryanscore = calcScore(answer)
                save_answer = answer
                check = True
                
    if check == False:
        return [-1]
    return save_answer