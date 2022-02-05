#스도쿠
#brute force
#back tracking

#틀린문제 -> 왜 틀리게 뜨는지 모르겠..

import sys

input = sys.stdin.readline
pann = []
zeros = []
for i in range(9):
    pann.append(list(map(int, input().split())))
    for j in range(9):
        if pann[i][j] == 0 :
            zeros.append((i, j))
result = False

def number(i,j):
    nl = [i for i in range(1, 10)]
    for k in range(9):
        if pann[i][k] in nl: #가로탐색
            nl.remove(pann[i][k])
        if pann[k][i] in nl: #세로탐색
            nl.remove(pann[k][i])  
    i //= 3
    j //= 3
    for p in range(i*3, (i+1)*3): #해당칸이 포함된 3x3에도
        for q in range(j*3, (j+1)*3) :
            if pann[p][q] in nl:
                nl.remove(pann[p][q])
    return nl

def answer(x):
    global result
    if result:
        return
    if x == len(zeros):
        for row in pann:
            print(*row)
        result = True
        return
    else:
        (i, j) = zeros[x]
        nl = number(i,j)
        for c in nl:
            pann[i][j] = c
            answer(x+1)
            pann[i][j] = 0

answer(0)
