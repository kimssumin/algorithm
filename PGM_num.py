def solution(n):
    answer = 0
    for i in range(1, n+1):
        s = 0
        for j in range(i, n+1):
            s += j
            if s == n:
                answer += 1
                break
            elif s > n:
                break

    return answer


# /*2nd*/
def expressions(num):
    return len([i for i in range(1, num+1, 2) if num % i is 0])
