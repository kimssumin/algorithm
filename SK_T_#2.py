def solution(periods, payments, estimates):
    vip = 0
    vip_x = 0
    n = len(periods)
    pay_sum_last = [0 for i in range(n)]
    pay_sum_next = [0 for i in range(n)]
    last = [0 for i in range(n)]
    for i in range(n):
        pay_sum_last[i] = sum(payments[i])
        pay_sum_next[i] = sum(payments[i]) - payments[i][0] + estimates[i]
        if periods[i] < 24:  # 현재 vip가 아닌 경우
            last[i] = 1
        elif 24 <= periods[i] < 60 and pay_sum_last[i] < 900000:  # 현재 vip가 아닌 경우
            last[i] = 1
        elif 60 <= periods[i] and pay_sum_last[i] < 600000:  # 현재 vip가 아닌 경우
            last[i] = 1

    for i in range(n):
        if 24 <= periods[i] + 1 < 60 and last[i] == 1:  # 전달 x, 담달o
            if pay_sum_next[i] >= 900000:
                vip += 1
        elif 60 <= periods[i] + 1 and last[i] == 1:  # 전달 x, 담달o
            if pay_sum_next[i] >= 600000:
                vip += 1
        elif last[i] == 0 and periods[i] + 1 < 60:  # 전달 o, 담달x
            if pay_sum_next[i] < 900000:
                vip_x += 1
        elif last[i] == 0 and periods[i] + 1 >= 60:  # 전달 o, 담달x
            if pay_sum_next[i] < 600000:
                vip_x += 1

    answer = [vip, vip_x]
    return answer

# 백화점 vip 납부예정
