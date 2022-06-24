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
    ans = 0
    for i in range(len(daylist)):
        if daylist[ans] < daylist[i]:      # 현재 인덱스의 작업일보다 큰 작업일이 나오면
            answer.append(i - ans)    # 둘의 차이(배포 개수)를 추가
            ans = i                   # 현재 인덱스를 갱신

    answer.append(len(daylist) - ans)    # 갱신된 인덱스부터 마지막 인덱스까지의 개수

    return answer


a = list(map(int, input().split()))
b = list(map(int, input().split()))
print(solution(a, b))
