#회의실 배정
#greedy


import sys

input = sys.stdin.readline
dis = []

n = int(input())
for _ in range(n):
    dis.apppend(list(map(int, input().split())))

dis.sort(key = lambda x:(x[1], x[0])) #끝나는 시간이 빠른 순
cnt = 1
end_time = dis[0][1]
for i in range(0, n-1):
    if end_time <= dis[i+1][0]: #시작시간
        cnt += 1
        end_time = dis[i+1][1]

print(cnt)
