

def solution(queue1, queue2):
    answer = 0
    q = queue1 + queue2
    target = sum(q)//2
    i, j = 0, len(queue1)-1
    now = sum(queue1)

    while (i < len(q) and j < len(q)):
        if now == target:
            return answer
        elif now < target and j < len(q) - 1:
            j += 1
            now += q[j]
            answer += 1
        else:
            now -= q[i]
            i += 1
            answer += 1
    return -1


print(solution([1, 2, 1, 2], [1, 10, 1, 2]))
