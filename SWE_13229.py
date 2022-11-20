T = int(input())

day_cnt = {"MON": 6, "TUE": 5, 'WED': 4,
           "THU": 3, "FRI": 2, 'SAT': 1, "SUN": 7}
for test in range(1, T+1):
    day = input()
    print('#'+str(test)+' '+str(day_cnt[day]))
