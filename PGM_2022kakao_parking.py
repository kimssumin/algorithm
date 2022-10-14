def timecal(intime, outtime):
    inhour = int(intime.split(':')[0])
    inmin = int(intime.split(':')[1])
    outhour = int(outtime.split(':')[0])
    outmin = int(outtime.split(':')[1])
    if inhour == outhour:
        #min 만 비교
        return outmin-inmin
    else:
        return (60*(outhour - inhour) + ((outmin-inmin)))
        # if outmin < inmin:
        #     #ex) 05:34 - 06:14
        #     return (60*(outhour - inhour) - (inmin-outmin))
        # else:


def solution(fees, records):
    answer = []
    rec = {}
    for r in records:
        ll = list(r.split())
        if ll[1] in rec:
            rec[ll[1]].append(ll[0])
        else:
            rec[ll[1]] = [ll[0]]
    rec = sorted(rec.items())

    answer = [0 for _ in range(len(rec))]
    index = -1

    for k in rec:
        index += 1
        if len(k[1]) % 2 != 0:
            answer[index] += timecal(k[1][-1], '23:59')
            for i in range(0, len(k[1])-1, 2):
                answer[index] += timecal(k[1][i], k[1][i+1])

        else:
            for i in range(0, len(k[1])-1, 2):
                answer[index] += timecal(k[1][i], k[1][i+1])

    #print(answer)
    for i, a in enumerate(answer):
        if a <= fees[0]:
            answer[i] = fees[1]
        else:
            if ((a - fees[0]) % fees[2] == 0):
                #나눠떨어지는 경우
                answer[i] = fees[1]
                answer[i] += fees[3] * (((a - fees[0]) // fees[2]))
            else:
                answer[i] = (
                    fees[3] * (((a - fees[0]) // fees[2])+1)) + fees[1]

    return answer
