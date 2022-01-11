#이진탐색
#떡볶이 떡 만들기
#parametric search - 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제 -> 이진탐색을 이용하여 해결

n, m = list(map(int, input().split( )))
array = list(map(int, input().split()))

start = 0
end = max(array)

result = 0
while (start <= end):
    total = 0
    mid = (start + end) // 2
    for x in array:
        if x > mid:
            total += x - mid
    if total < m:
        end = mid - 1
    else:
        result = mid 
        start = mid + 1

print(result)