#공유기 설치
#binary search

import sys
input = sys.stdin.readline

n , c = map(int, input().split())
home = []

for _ in range(n):
    home.append(int(input()))
    
home.sort()

def binary_search(home, start, end):
    while start <= end:
        mid = (start + end) // 2
        current = home[0]
        cnt = 1

        for i in range(1, len(home)):
            if home[i] >= current + mid:
                cnt += 1
                current = home[i]

        if cnt >= c :
            global answer
            start = mid + 1
            answer.append(mid)
        else:
            end = mid - 1

start = 1
end = home[-1] - home[0]
answer = []

binary_search(home, start, end)
print(max(answer))
