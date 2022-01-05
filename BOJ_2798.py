#구현알고리즘, 브루트포스유형

import itertools

N, M = map(int, input().split())
cards = list(map(int, input().split()))

res = 0

for case in itertools.combinations(cards, 3):
    if res < sum(case) <= M:
        res = sum(case)

print(res)