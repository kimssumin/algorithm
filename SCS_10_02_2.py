# 치맥
#

def solve(a, b, t):
    a_max = t // a
    b_max = t // b
    for i in range(0, a_max + 1):
        for j in range(0, b_max + 1):
            if t-((a * i) + (b * j)) >= 0:
                answer.append([i + j, t-((a * i) + (b * j))])
    answer.sort(key=lambda x: (x[1], -x[0]))
    if answer[0][1] != 0:
        print(answer[0][0], answer[0][1])
    elif answer[0][1] == 0:
        print(answer[0][0])


a, b, t = [int(x) for x in input().split()]
answer = []
solve(a, b, t)
