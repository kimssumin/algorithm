#단어수학
#brute force

import sys

N = int(input())
words = []
input = sys.stdin.readline
for _ in range(N):
    words.append(input().strip())
alphabet = [0 for i in range(26)]

for wr in words:
    i = 0
    while wr:
        curr = wr[-1]
        alphabet[ord(curr) - ord('A')] += (10 ** i)
        i += 1
        wr = wr[:-1]
alphabet.sort(reverse = True) #큰 -> 작은
result = 0

for i in range(9, 0, -1):
    result += i * alphabet[9 - i]
print(result)
    