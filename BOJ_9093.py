#단어뒤집기

import sys

N = int(input())

for _ in range(N):
    input = sys.stdin.readline()
    sen = list(map(str, input.split()))
    new_sen = []
    for i in sen:
        new_sen.append(i[::-1])
    for j in new_sen:
        print(j, end = ' ')
    print()