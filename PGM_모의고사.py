#모의고사
#완전탐색

def solution(answers):
    answer = []
    cnt1, cnt2, cnt3 = 0, 0, 0
    li1 = [1,2,3,4,5] * 2000
    li2 = [2,1,2,3,2,4,2,5] * 1250
    li3 = [3,3,1,1,2,2,4,4,5,5] * 1000
    
    for v1,v2, v3, res in zip(li1, li2, li3, answers):
        if v1 == ans:
            cnt1 += 1
        if v2 == ans:
            cnt2 += 1
        if v3 == ans:
            cnt3 += 1
            
    tmp = [cnt1, cnt2, cnt3]
    max_tmp = max(tmp)

    for i, v in enumerate(tmp):
        if v == max_tmp :
            answer.append(i+1)
    return answer