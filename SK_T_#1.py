def solution(p):
    n = len(p)
    answer = [0 for _ in range(n)]
    for i in range(n):
        min_index = i
        for j in range(i+1, n):
            if p[j] < p[min_index]:
                min_index = j
        p[i], p[min_index] = p[min_index], p[i]
        if i != min_index:
            answer[i] += 1
            answer[min_index] += 1
    return answer


# select sort 시 변하는 count
