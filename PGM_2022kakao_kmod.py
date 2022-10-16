

def divs(n, q):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)

    return rev_base[::-1] 
    # 역순인 진수를 뒤집어 줘야 원래 변환 하고자하는 base가 출력
    

# 소수 판별 함수(에라토스테네스의 체)
def is_prime_number(n):
    if n == 1:
        return False
    for i in range(2, int(n**(1/2))+1):
        if n % i == 0:
            return False
    return True

def solution(n, k):
    answer = 0
    s = divs(n, k)
    ls = list(str(s).split('0'))
    
    if len(ls) != 0:
        for i in ls:
            if i != '' and is_prime_number(int(i)):
                #print(i)
                answer += 1
    return answer