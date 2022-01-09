#정렬
#성적이 낮은 순서로 학생 출력하기

import sys
N = int(input())
array = []

for _ in range(N):
    input = sys.stdin.readline()
    name, score = map(str, input.split())
    score = int(score)
    array.append((name, score))

nes = sorted(array, key = lambda x:x[1])
for array in nes:
    print(array[0])