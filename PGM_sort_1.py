# k번째 수

def solution(array, commands):
    answer = []
    for i in commands:
        start = i[0]
        end = i[1]
        find = i[2]
        li = array[start-1: end]
        li.sort()
        answer.append(li[find-1])
    return answer


a = list(map(int, input().split()))
b = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
print(solution(a, b))
