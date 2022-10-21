# 영어끝말잇기

def solution(n, words):
    answer = []
    all_log = [words[0]]
    back = words[0][-1]
    for i in range(1, len(words)):
        number = (i+1) % n
        if number == 0:
            number = n
        if words[i].startswith(back) and not words[i] in all_log:
            all_log.append(words[i])
            back = words[i][-1]
        else:
            answer.append(number)
            if number == n:
                answer.append((i+1) // n)
            else:
                answer.append(((i+1) // n)+1)
            return answer

    return [0, 0]
