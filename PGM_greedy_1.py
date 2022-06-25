# 체육복


'''
def find(i, reserve, n):
    for j in reserve:
        if i - 1 == j or i + 1 == j:
            return j
        elif i == j:
            return n+2
        else:
            return 0


def solution(n, lost, reserve):
    answer = 0
    all_lost = len(lost)
    for i in lost:
        jj = find(i, reserve, n)
        if jj == 0:
            continue
        elif jj == n+2:
            reserve.remove(i)
            all_lost -= 1
        else:
            reserve.remove(jj)
            all_lost -= 1
        if len(reserve) == 0:
            break
    answer = n - all_lost
    return answer
'''


def solution(n, lost, reserve):
    reserve_ = set(reserve) - set(lost)
    lost_ = set(lost) - set(reserve)
    for i in reserve_:
        if i-1 in lost_:
            lost_.remove(i-1)
        elif i+1 in lost_:
            lost_.remove(i+1)
    return n - len(lost_)


print(solution(5, [2, 4, 5], [2]))
