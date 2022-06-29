# 멀쩡한 사각형

def solution(w, h):
    answer = 0
    m = (-1) * h/w
    for i in range(1, w):
        bi = (m * (i - w))
        bbi = int(bi)
        answer += bbi
    answer *= 2

    return answer
# 시간초과
# 약수 이용해서 풀어야되는듯함
