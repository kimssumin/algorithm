# 가장 큰 수
# sort

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x * 3, reverse=True)
    # x * 3을 하는 이유?
    #   num 인자 각각의 문자열을 3번 반복한다는 뜻이다.
    #   num의 인수값이 1000 이하이므로 3자리수로 맞춘 뒤, 비교하겠다는 뜻.
    answer = str(int(''.join(numbers)))
    # int 변환 후 다시 str 변환하는 이유
    #    모든 값이 0일 때(즉, ‘000’을 처리하기 위해) int로 변환한 뒤, 다시 str로 변환한다.
    return answer
