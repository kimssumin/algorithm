from itertools import combinations as com


def calcScore(arr):
    score = 0
    for idx, s in enumerate(arr):
        if s != 0:
            if 10-idx <= 0:
                score += 0
            else:
                score += (10-idx)
    return score


def ryanSuccess(peach, ryan):
    new = [ai - bi for ai, bi in zip(peach, ryan)]
    for idx, i in enumerate(new):
        if i < 0:
            new[idx] = 0
    if (calcScore(new) < calcScore(ryan)):
        return True
    return False


def solution(n, info):
    score = sum([10-i for i in range(10)])
    peachscore = calcScore(info)
    ryanscore = 0
    basescore = [i+1 for i in info]
    save = []
    for i in range(1, 12):
        for l in (list(com([x for x in range(11)], i))):
            check_sumn = sum([basescore[b] for b in list(l)])
            if check_sumn == n:
                candidate = []
                for i in range(11):
                    if i in list(l):
                        candidate.append(basescore[i])
                    else:
                        candidate.append(0)
                print(candidate, calcScore(candidate))
                if ryanscore < calcScore(candidate) and ryanSuccess(info, candidate):
                    ryanscore = calcScore(candidate)
                    save = candidate
                elif ryanscore == calcScore(candidate) and ryanSuccess(info, candidate):
                    for i in range(10, -1, -1):
                        if save[i] == candidate[i]:
                            continue
                        elif save[i] < candidate[i]:
                            save = candidate
                            ryanscore = calcScore(candidate)
                        else:
                            break
    if ryanscore == 0:
        return [-1]
    else:
        return [save, ryanscore]


# 3,2,2,2,1,1,1,1,1,1,1
#(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]))
print(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]))
