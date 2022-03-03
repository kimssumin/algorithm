# K번째 수
# sort

def solution(array, commands):
    answer = []
    for a in commands:
        i, j, k = a[0] - 1, a[1] - 1, a[2] - 1
        new = array[i:j+1]
        new.sort()
        answer.append(new[k])

    return answer
