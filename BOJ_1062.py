#가르침
#brute force
#시간초과


import sys

n, k = map(int, input().split())
words = [set(sys.stdin.readline().rstrip()) for _ in range(n)]


if k < 5:
    print(0)
    exit()

elif k == 26:
    print(n)
    exit()

res = 0
learn = [0] * 26

for c in ('a', 'n', 't', 'i', 'c'):
    learn[ord(c) - ord('a')] = 1

def dfs(i, cnt):
    global res
    if cnt == k-5:
        cnt2 = 0
        for word in words:
            check = True
            for w in word:
                if not learn[ord(w) - ord('a')]:
                    check = False
                    break
            if check:
                cnt2 += 1
        res = max(res, cnt2)
        return 
    for ins in range(i, 26):
        if not learn[ins]:
            learn[ins] = True
            dfs(ins, cnt+1)
            learn[ins] = False
dfs(0,0)
print(res)
