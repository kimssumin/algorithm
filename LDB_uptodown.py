#정렬
#위에서 아래로

N = int(input())
array = []

for _ in range(N):
    i = int(input())
    array.append(i)

array = sorted(array, reverse = True)

for i in array :
    print(i, end = ' ')