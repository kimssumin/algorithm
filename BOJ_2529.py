#부등호
#brute force

import sys

# 어떤 수가 부등호 조건을 만족하는지 검사하는 함수
def is_possible(i, before, current):
    if input_signs[i] == '<' and before < current:
        return True
    if input_signs[i] == '>' and before > current:
        return True

    return False


# 주어진 부등호 조건을 만족하는 가장 큰 수를 찾아 max_list에 저장하는 함수
def find_max(num_list, i, before):
    global max_list

    # 조건을 만족하는 가장 큰 k자리 수를 찾았다면
    if i >= k:
        max_list = num_list
        return

    for num in range(9, -1, -1):
        # 아직 가장 큰 수를 찾지 못했고, 숫자 num이 아직 사용되지 않았다면
        if not max_list and num not in num_list:
            if is_possible(i, before, num):
                find_max(num_list + [num], i + 1, num)


# 주어진 부등호 조건을 만족하는 가장 작은 수를 찾아 min_list에 저장하는 함수
def find_min(num_list, i, before):
    global min_list
    
    # 조건을 만족하는 가장 작은 k자리 수를 찾았다면
    if i >= k:
        min_list = num_list
        return

    for num in range(10):
        # 아직 가장 작은 수를 찾지 못했고, 숫자 num이 아직 사용되지 않았다면
        if not min_list and num not in num_list:
            if is_possible(i, before, num):
                find_min(num_list + [num], i + 1, num)


k = int(sys.stdin.readline())
input_signs = list(sys.stdin.readline().split())
max_list = []
min_list = []

for x in range(10):
    if not max_list:
        find_max([9 - x], 0, 9 - x)
    if not min_list:
        find_min([x], 0, x)

print(str(''.join(map(str, max_list))))
print(str(''.join(map(str, min_list))))