#외판원 순회2
#brute force
#dfs

from itertools import permutations as per
import sys

input = sys.stdin.readline

def main():
    
    n = int(input())
    way = [[0] * n for _ in range(n)]
    
    for x in range(n):
        s = list(map(int, input().split()))
        for i in range(n):
            way[x][i] = s[i]
        
    sum = int(1e9)
    
    for i in per(range(n)):
        p = list(i)
        if way[p[n-1]-1][p[0]-1] == 0:
            continue
        way_sum = 0
        prog = True
        #way_sum = way[p[n-1]-1][p[0]-1]
        for i in range(n-1):
            if way[p[i]-1][p[i+1]-1] == 0:
                prog = False
                #way_sum = int(1e9)
                break
            way_sum += way[p[i]-1][p[i+1]-1]
            if way_sum >= sum:
                prog = False
                break
        if prog == False:
            continue
        way_sum += way[p[n-1]-1][p[0]-1]
    
        sum = min(sum, way_sum)
        #print(p[1])
    print(sum)

main()



#시간초과 - 1차작성코드
'''from itertools import permutations as per
import sys

n = int(input())
input = sys.stdin.readline
way = []
city = [i for i in range(1, n+1)]

for _ in range(n):
    way.append(list(map(int, input().split())))

sum = int(1e9)

for i in per(city):
    p = list(i)
    if way[p[n-1]-1][p[0]-1] == 0:
        break
    way_sum = way[p[n-1]-1][p[0]-1]
    for i in range(n-1):
        if way[p[i]-1][p[i+1]-1] == 0:
            way_sum = int(1e9)
            break
        way_sum += way[p[i]-1][p[i+1]-1]

    sum = min(sum, way_sum)
    #print(p[1])
print(sum)'''