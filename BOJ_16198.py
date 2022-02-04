#에너지모으기
#brute force

import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)
n = int(input())
wl = list(map(int, input().split()))
energy = 0

def sel(curr):
    if len(wl) == 2:
        global energy
        if energy < curr:
            energy = curr
            return
    for i in range(1, len(wl)-1):
        x = wl[i]
        curr += wl[i-1] * wl[i+1]
        del wl[i]
        sel(curr)
        wl.insert(i, x) #다시 sel 함수에 영향을 미치지 않기위해 원상복구
        curr -= (wl[i-1] * wl[i+1])

sel(0)
print(energy)


