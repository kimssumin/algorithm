# 구명보트

def solution(people, limit):
    answer = 0
    people.sort()
    start = 0
    end = len(people) - 1
    while start <= end:
        answer += 1
        if people[end] + people[start] <= limit:
            start += 1
        end -= 1

    return answer


print(solution([70, 50, 80, 50], 100))
