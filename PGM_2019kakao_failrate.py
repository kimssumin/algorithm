# 실패율

def solution(N, stages):
    result = {}
    s = len(stages)
    for stage in range(1, N+1):
        if s != 0:
            son = stages.count(stage)
            result[stage] = son / s
            s -= son
        else:
            result[stage] = 0
    return sorted(result, key=lambda x: result[x], reverse=True)
