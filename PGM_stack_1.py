# 기능 개발

def solution(progresses, speeds):
    answer = []
    daylist = []
    for pro in range(len(progresses)):
        if (100 - progresses[pro]) % speeds[pro] == 0:
            day = (100 - progresses[pro]) // speeds[pro]
            daylist.append(day)
        else:
            day = (100 - progresses[pro]) // speeds[pro] + 1
            daylist.append(day)
    ans = 1
    print(daylist)
    for i in range(1, len(daylist)):
        maxx = daylist[0]
        if daylist[i] <= daylist[i-1]:
            ans += 1
            if i == len(daylist) - 1:
                answer.append(ans)
        else:
            answer.append(ans)
            ans = 1
            maxx = daylist[i]
            if i == len(daylist) - 1:
                answer.append(ans)

    return answer


a = list(map(int, input().split()))
b = list(map(int, input().split()))
print(solution(a, b))
