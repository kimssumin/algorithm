#brute force
#일곱난쟁이

import sys

mini = []
input = sys.stdin.readline


for _ in range (9):
    mini.append(int(input()))
total = sum(mini)

for i in range(9):
    for j in range(i+1,9):
        if 100 == total - (mini[i] + mini[j]): 
            n1,n2=mini[i],mini[j]

            mini.remove(n1)
            mini.remove(n2)
            mini.sort()

            for i in range(len(mini)):
                print(mini[i])
            break

    if len(mini)<9:
        break