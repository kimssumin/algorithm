# 큰 수 만들기

def solution(number, k):
    answer = []  # Stack

    for num in number:
        while k > 0 and answer and answer[-1] < num:
            answer.pop()
            k -= 1
        answer.append(num)

    return ''.join(answer[:len(answer) - k])


'''
sol2) combination -> 시간초과
from itertools import combinations as com

def solution(number, k):
    num = [n for n in number]
    n = len(number)
    new = list(com(num, n-k))
    answer = 0
    for i in new:
        a = int("".join(i))
        answer = max(answer, a)
    answer = str(answer)
    return answer
'''
