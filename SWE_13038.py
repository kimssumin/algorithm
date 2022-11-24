T = int(input())

for test in range(1, T+1):
    n = int(input())
    an = list(map(int, input().split()))
    timeForWeek = an.count(1)
    idx = an.index(1)
    if timeForWeek >= n:
        daycnt = timeForWeek
        rest = daycnt
        cnt = 0
        for i in range(7):
            rest -= an[i]
            cnt += 1
            if (rest == 0):
                break
        print('#'+str(test)+' '+str(cnt - idx))
    else:
        if (n % timeForWeek) == 0:
            val = (n // timeForWeek) - 1
        else:
            val = n // timeForWeek
        daycnt = (val) * 7
        rest = n - (timeForWeek * (val))
        cnt = 0
        for i in range(7):
            rest -= an[i]
            cnt += 1
            if (rest == 0):
                daycnt += cnt
                break
        print('#'+str(test)+' '+str(daycnt - idx))
