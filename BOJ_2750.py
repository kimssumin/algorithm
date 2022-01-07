#정렬

#선택정렬
N = int(input())
list = []

for i in range(N):
    list.append(int(input()))

for j in range(len(list)):
    min_index = j
    for k in range(j+1, len(list)):
        if list[k] < list[min_index]:
            min_index = k
    list[j], list[min_index] = list[min_index], list[j]

print(list)

'''
삽입정렬)
#정렬

#선택정렬
N = int(input())
list = []

for i in range(N):
    list.append(int(input()))

for j in range(1,len(list)):
    for k in range(j, 0, -1):
        if list[k] < list[k-1] :
            list[k], list[k-1] = list[k-1],list[k]
        else:
            break

for i in list:
    print(i, end = '\n')
'''