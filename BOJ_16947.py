#서울 지하철 2호선
#graph
#dfs & bfs

#풀다 포기,,, 문제이해부터 제대로 다시하기
#https://velog.io/@dailyhyun/BOJ%EB%B0%B1%EC%A4%80-16947.-%EC%84%9C%EC%9A%B8-%EC%A7%80%ED%95%98%EC%B2%A0-2%ED%98%B8%EC%84%A0

from os import stat
import sys
from collections import deque
sys.setrecursionlimit(1000000)

def dfs(x, start, v):
    visit[x] = True
    if x in station[start] or x == start :
        if v>=3:
            cycle.append(x)
            return
    for i in station[x]:
        if visit[i] == False:
            dfs(i, start, v+1)
            visit[i] = False       


n = int(input())
station = [[i] for i in range(n)]

for _ in range(n):
    s, sr = map(int, sys.stdin.readline().split())
    station[s].append(sr)
    station[sr].append(s) #양방향
visit = [False] * (n+1)
cycle = False



for i in range(1, n+1):
    dfs(i, i, 1)
    visit[i] = False




