def divs(n, q):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)

    return rev_base[::-1]
    # 역순인 진수를 뒤집어 줘야 원래 변환 하고자하는 base가 출력


def is_prime_number(x):
    # 2부터 (x - 1)까지의 모든 수를 확인하며
    if x == 1:
        return False
    else:
        for i in range(2, x):
            # x가 해당 수로 나누어떨어진다면
            if x % i == 0:
                return False  # 소수가 아님
        return True  # 소수임


def solution(n, k):
    answer = 0
    s = divs(n, k)

    if s.includes('0') == False and is_prime_number(int(s)):
        print()
    ls = list(str(s).split('0'))
    if len(ls) != 0:
        for i in ls:
            if i != '' and is_prime_number(int(i)):
                # print(i)
                answer += 1

    return answer
