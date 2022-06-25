# 큰 수 만들기


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
