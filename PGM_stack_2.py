# 프린터

from collections import deque


def solution(priorities, location):
    answer = 0
    data = deque(priorities)
    index = deque([])
    for i in range(len(priorities)):
        index.append(i)

    cnt = 1
    while len(data) != 1:
        temp1 = data.popleft()
        temp2 = index.popleft()
        if max(data) > temp1:
            data.append(temp1)
            index.append(temp2)
        else:
            if temp2 == location:
                break
            cnt += 1
    answer = cnt
    return answer


a = [1, 1, 9, 1, 1, 1]
b = 0

print(solution(a, b))

'''def solution(priorities, location):
    priorities = deque(priorities)
    answer = 0
    ans_list = []
    find = priorities[location]
    max_p = max(priorities)
    lengths = len(priorities)
    while len(ans_list) != lengths:
        if priorities[0] != max_p:
            aa = priorities.popleft()
            priorities.append(aa)
        else:
            aa = priorities.popleft()
            ans_list.append(aa)
            if len(priorities) != 0:
                max_p = max(priorities)
    answer = ans_list.index(find) + 1
    return answer'''
