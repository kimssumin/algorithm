# 로마 숫자 만들기
# brute force

# 핵심은 combinations_with_replacement 를 사용하는 것

from itertools import combinations_with_replacement

n = int(input())
res = []
nums = [1, 5, 10, 50]

'''
A = [1,1,3,3,3]
>> print list(combinations(A,2))
[(1, 1), (1, 3), (1, 3), (1, 3), (1, 3), (1, 3), (1, 3), (3, 3), (3, 3), (3, 3)]'''

for case in combinations_with_replacement(range(4), n):
    sum = 0
    for i in case:
        sum += nums[i]
    if sum in res:
        continue
    else:
        res.append(sum)

print(len(res))
