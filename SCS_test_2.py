'''
n, m = [int(x) for x in input().split()]
perm = [int(x) for x in input().split()]

garo = [None] * m
for k in range(m):
    i, j = input().split()
    garo[k] = [int(i), int(j)]
        
garo.sort(reverse=True, key=lambda g: g[1])

for i in range(m-1):
    if garo[i][1] == garo[i+1][1]: # same y-coord
        if abs(garo[i][0]-garo[i+1][0]) <= 1:
            print("illegal garo sticks")
            exit()

k = n//2
for g in range(m):
    if garo[g][0] == k: # k - (k+1)
        k = k+1
    elif garo[g][0] == k-1: # (k-1) - k
        k = k-1
        
print(perm[k])
'''
