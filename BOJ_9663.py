#N_Queen
#brute force
#dfs

#python 으로 통과 X -> Pypy3
import sys
sys.setrecursionlimit(100000)

n = int(input())
result = 0
col = [0]* n
visited = [False for _ in range(n)]

def check(x):
    for i in range(x):
        if col[x] == col[i] or abs(col[i]-col[x]) == x-i:
            return False
    return True

def dfs(x):
    global result
    if x== n:
        result += 1
        return
    else:
        for i in range(n):
            if visited[i]:
                continue
            col[x] = i #(x, i)에 퀸올리기
            if check(x):
                visited[i] = True
                dfs(x+1) #다음행으로 
                visited[i] = False

dfs(0)
print(result)
