#1차원 배열

T = int(input())
for i in range(T):  
    f = int(input())  
    n = int(input())  
    f0 = [x for x in range(1, n+1)]  
    for k in range(f): 
        for i in range(1, n): 
            f0[i] += f0[i-1]  
    print(f0[-1])

