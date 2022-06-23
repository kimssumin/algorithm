# 완주하지 못한 선수

import collections


def solution(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
    return participant[-1]
    # answers = collections.Counter(
    #     participant) - collections.Counter(completion)
    # return list(answers.keys())[0]


a = ["leo", "kiki", "eden"]
b = ["eden", "kiki"]
print(solution(a, b))

'''
def solution(participant, completion):
    answers = collections.Counter(
        participant) - collections.Counter(completion)
    return list(answers.keys())[0]


a = ["leo", "kiki", "eden"]
b = ["eden", "kiki"]
print(solution(a, b))'''
