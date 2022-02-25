#놀이공원
#binary search

n,m  = map(int, input().split())
time = list(map(int, input().split()))

if n < m:
    print(n)

else:
    left, right = 0, 600000000
    t = None
    while left <= right :
        mid = (left + right ) // 2
        cnt = m
        for i in range(m):
            cnt += mid // time[i]
        if cnt >= n: #n명을 태울 수 있는 상황
            t = mid
            right = mid - 1
        else:
            left = mid + 1
        
        #t-1에 탑승한 아이들의 숫자 계산
        cnt = m
        for i in range(m):
            cnt  += (t-1) // time[i]
        
        #t에 탑승한 아이를 계산
        for i in range(m):
            if t % time[i] == 0:
                cnt += 1
            if cnt == n:
                print(i+1)
                break
            