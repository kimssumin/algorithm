#카드
#sort

import sys
from collections import Counter 

n = int(input())
input = sys.stdin.readline
cards = []

for _ in range(n):
    cards.append(int(input()))

count = Counter(cards)
print(sorted(count.items(), key = lambda x: (-x[1], x[0]))[0][0])