# 샛강 건너기
# 폭 L, n 개의 돌, 시작위치 0 , 끝나는 위치 L
# 인접한 돌 사이의 최소 거리 이상 점프

l, n, k = map(int ,input().split())
import sys
input = sys.stdin.readline
stone = list(map(int, input().split()))
dis = [stone[0]]

for x in range(1, len(stone)):
	dis.append(stone[x] - stone[x-1])
dis.append(l - stone[n-1])
print(dis)
#for _ in range(k):
	