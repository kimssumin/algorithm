# 샛강 건너기
# 폭 L, n 개의 돌, 시작위치 0 , 끝나는 위치 L
# 인접한 돌 사이의 최소 거리 이상 점프

import sys
l, n, k = map(int, input().split())
input = sys.stdin.readline
stone = list(map(int, input().split()))
stone.append(l)
