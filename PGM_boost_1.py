
cal = []
lst = []
for i in range(1, 13):
    for j in range(1, 32):
        if i == 2:
            if j == 29:
                break
            if j == 1:
                lst.append(str(i)+"/1")
            else:
                lst.append(str(j))
            if len(lst) == 7:
                cal.append(lst)
                lst = []
        elif i == 2 or i == 4 or i == 6 or i == 9 or i == 11:
            if j == 31:
                break
            if j == 1:
                lst.append(str(i)+"/1")
            else:
                lst.append(str(j))
            if len(lst) == 7:
                cal.append(lst)
                lst = []
        else:
            if j == 1:
                lst.append(str(i)+"/1")
            else:
                lst.append(str(j))
            if len(lst) == 7:
                cal.append(lst)
                lst = []
cal.append(["31"])
# print(cal)

except_list = [[2, 29], [2, 30], [2, 31], [4, 31], [6, 31], [9, 31], [11, 31]]


def solution(month, day, weeks):
    answer = []
    finds = str(month) + "/"+str(day)
    w = 100
    nexts = month + 1
    for e in except_list:
        if e[0] == month and e[1] == day:
            if e[0] == 2:
                day = 28
            else:
                day = 30

    # 달부터 찾기
    for week in cal:
        if (str(month)+"/1") in week:
            m = cal.index(week)
        if (str(nexts)+"/1") in week:
            m_e = cal.index(week)
            break
        if (str(nexts)+"/1") not in week:
            m_e = len(cal) - 1

    # 주 찾기
    for week in range(m, m_e+1):
        if str(day) in cal[week] or finds in cal[week]:
            w = week

    for _ in range(weeks):
        answer.append(cal[w])
        w += 1
    for i in range(2):
        for k in answer[i]:
            if len(k) >= 3:
                mm = k.split("/")[0]
                start = int(mm)-1
                break
    ori = answer[0][0]
    if len(answer[0][0]) < 3:
        answer[0][0] = str(start)+"/"+ori
    return answer


print(solution(1, 1, 53))
