import math

#p = 0

A = int(input())

def is_prime_sqrt(x): 
    nots = 0
    for i in range (2, int(math.sqrt(x))+1):
        if x % i == 0 :
            nots += 1
            break
        else:
            continue
    if nots != 0 :
        return 'not prime'
    else :
        return 'prime'

print(is_prime_sqrt(A))

