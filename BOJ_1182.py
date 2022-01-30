#부분수열의 합
#brute force 

from itertools import combinations as com

n, s = map(int, input().split())
lst = list(map(int, input().split()))

cnt = 0

for i in range(1, n+1):
    combi = list(com(lst, i))
    for j in combi: 
        if sum(list(j)) == s:
            cnt += 1
        
print (cnt)

    
