#이진탐색
#시간복잡도 O(logN)

def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = ((start+end) // 2)
    if array[mid] == target :
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    else:
        return binary_search(array, target, mid+1, end)

n, target = list(map(int, input().split()))
array = list(map(int, input().split()))

res = binary_search(array, target, 0 , n-1)
if res == None:
    print("원소가 존재하지 않습니다")
else:
    print(res + 1)