import heapq


def solution(operations):
    answer = []
    max_q = []
    min_q = []

    for oper in operations:
        if oper.split()[0] == 'I':
            heapq.heappush(max_q, -(int(oper.split()[1])))
            heapq.heappush(min_q, int(oper.split()[1]))
        else:
            if int(oper.split()[1]) == 1:
                if (len(max_q) != 0):
                    min_q.remove(-(heapq.heappop(max_q)))
            else:
                if (len(min_q) != 0):
                    max_q.remove(-heapq.heappop(min_q))

    if (len(max_q) != 0):
        answer.append(-heapq.heappop(max_q))
    else:
        answer.append(0)
    if (len(min_q) != 0):
        answer.append(heapq.heappop(min_q))
    else:
        answer.append(0)
    return answer
