# 필사의 탈출

# 남왕국으로 자객의 탈출 - 장벽 세개 통과
# 통로의 개수

u = int(input())  # 가장 위 구멍의 수
uu = list(map(int, input().split()))  # 가장 위 구멍의 x 좌표
m = int(input())  # 중간 구멍의 수
mm = list(map(int, input().split()))  # 중간 구멍의 x 좌표
l = int(input())  # 가장 아래 구멍의 수
ll = list(map(int, input().split()))  # 가장 아래 구멍의 x 좌표

cnt = 0

for i in range(u):
    for j in range(m):
        ck = uu[i] - mm[j]  # 차
        for k in range(l):
            if mm[j] - ll[k] == ck:
                cnt += 1
                #print(ck, ll[k])

print(cnt)


'''
import math
import os
import random
import re
import sys

# Complete the beautifulTriplets function below.

if __name__ == '__main__':
n,d=map(int,input().split())
arr=list(map(int,input().split()))
cnt = 0
for i in range(len(arr)):
if arr[i]+d in arr and arr[i]+2*d in arr:
cnt += 1
print(cnt)


출처: https://leechamin.tistory.com/358 [참신러닝 (Fresh-Learning)]'''
