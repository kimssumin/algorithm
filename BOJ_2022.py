#사다리
#binary search

import sys
input = sys.stdin.readline 
x, y, c = map(float, input().split())

def cal(x, y, w):
    h1 = (x**2-w**2)**0.5
    h2 = (y**2-w**2)**0.5    
    c = h1*h2 / (h1+h2)
    return c

s, e = 0, min(x,y)
res = 0
while e-s > 0.000001:
    m = (s+e)/2
    if cal(x,y,m) >= c:
        res = m
        s = m
    else:
        e = m
print('%.03f'%res)