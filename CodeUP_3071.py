#에라토스테네스의 체
#BOJ_1929 와 유사

A, B = map(int, input().split())
array = []

for i in range(A, B+1):
    if i == 1 :
        pass
    elif i == 2 :
        array.append(i)
    else:
        for j in range (2, i):
            if i % j == 0:
                break
            elif j == i-1 :
                array.append(i)

for k in array:
    print(k)


