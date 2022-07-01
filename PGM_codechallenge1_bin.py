# 이진 변환 반복하기

def translate(s):
    init_s = len(s)
    global new
    new_s = ""
    zero_count = 0
    for i in s:
        if i == '1':
            new_s += i
    zero_count += init_s - len(new_s)
    new = format(len(new_s), 'b')
    return zero_count


def solution(s):
    answer = []
    cnt = 0
    zero_cnt = 0
    while(1):
        cnt += 1
        zero_cnt += translate(s)
        s = new
        if len(s) == 1:
            answer = [cnt, zero_cnt]
            return answer

    return answer
