#그리디알고리즘 - 거스름돈


pay = int(input())

re = 1000 - pay
money = [500, 100, 50, 10 ,5, 1]
cnt = 0

for i in money :
    cnt = cnt + (re // i)
    re = re % i

print (cnt)
