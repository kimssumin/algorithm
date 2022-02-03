#연산자 끼워넣기
#brute force

import sys

n = int(input())
input = sys.stdin.readline().strip()
nums= list(map(int, input.split()))
a,s,m,d = map(int, input.split())

max_res , min_res = -sys.maxsize -1, sys.maxsize

def calcu(num, i, add, sub, mul, div):
    global max_res, min_res
    if i == n:
        max_res = max(max_res, num)
        min_res = min(min_res, num)
        return
    if add > 0 :
        calcu(num + nums[i], i + 1, add -1, sub, mul, div)
    if sub > 0:
        calcu(num - nums[i], i + 1, add, sub - 1, mul, div)
    if mul > 0:
        calcu(num *  nums[i], i + 1, add, sub , mul -1, div)
    if div > 0:
        calcu(int(num /  nums[i]), i + 1, add, sub, mul, div -1)

calcu(nums[0], 1, a,s,m,d)
print(max_res)
print(min_res)