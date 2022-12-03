from itertools import combinations_with_replacement


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
    answer = [-1]
    max_gap = -1
    # 중복 조합으로 0~10점까지 n개 뽑기
    for combi in combinations_with_replacement(range(11), n):
        candidate = [0] * 11  # 라이언의 과녁 점수

        for i in combi:  # combi에 해당하는 화살들을 라이언 과녁 점수에 넣기
            candidate[10 - i] += 1

        apeach, ryon = 0, 0
        for idx in range(11):
            if info[idx] == candidate[idx] == 0:
                continue
            elif info[idx] >= candidate[idx]:
                apeach += 10-idx
            else:
                ryon += 10 - idx

        if ryon > apeach:
            gap = ryon - apeach
            if gap > max_gap:
                max_gap = gap
                answer = candidate
    return answer


# 3,2,2,2,1,1,1,1,1,1,1
# (solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]))
print(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]))
