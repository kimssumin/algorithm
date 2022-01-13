#quick 정렬

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end: #원소가 1개인 경우 종료
        return
        
    pivot = start #피벗은 첫번째원소
    left = start + 1
    right = end
    while left <= right :
        while left <= end and array[left] <= array[pivot]:  #피벗보다 큰 데이터를 찾을 때까지 반복
            left += 1
        while right > start and array[right]>= array[pivot]:  #피벗보다 작은 데이터를 찾을 때까지 반복
            right -= 1
        if left > right: #엇갈렸다면 작은 데이터와 피벗을 교체
            array[right], array[pivot] = array[pivot], array[right]
        else: #엇갈리지 않았다면 작은데이터와 큰 데이터를 교체
            array[left], array[right] = array[right], array[left]

    #분할 이후 왼쪽부분과 오른쪽부분에서 각각 정렬을 수행
    quick_sort(array, start, right-1)
    quick_sort(array, right +1, end)

quick_sort(array, 0, len(array)-1)
print(array)