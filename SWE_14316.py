import itertools


def cases(num, origin_num):
    all_test = itertools.permutations(num, len(num))
    for i in list(all_test):
        s = int(''.join(map(str, i)))
        if s % origin_num == 0:
            print(s)
            return True
    return False


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    num = list(map(int, input()))
    origin = num[0]
    origin_num = int(''.join(map(str, num)))
    num.sort(reverse=True)
    if num[0] == origin:
        print('#'+str(test_case)+' impossible')
    else:
        if cases(num, origin_num):
            print('#'+str(test_case)+' possible')
