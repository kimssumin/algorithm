# 샛강 건너기
# 폭 L, n 개의 돌, 시작위치 0 , 끝나는 위치 L
# 인접한 돌 사이의 최소 거리 이상 점프

# 이분탐색 활용
# 시간복잡도 O(n^2) 추정 (최악의 경우)

import sys

l, n, k = map(int, input().split())  # l, n, k 입력받음
input = sys.stdin.readline
stone = list(map(int, input().split()))  # stone 입력 받음
stone.append(l)  # 마지막돌부터 L까지도 고려 (O(1))

left, right = 0, l  # 이분탐색용 변수 두개 설정(left 0, right= 강의 끝 지점 l)

while left <= right:  # 시간복잡도 : 최악의 경우 O(n)
    mid = (left + right) // 2  # 점프값의 최솟값을 mid 로 기준을 잡는다
    # 만약 result 값이 mid값이라면 돌을 k 개 제거했을 때 최소값이 mid 값인경우가 존재
    min_dis = 1e9  # 각 mid에서 최솟값, 초기값은 1e9(inf)로 설정
    curr, delete = 0, 0  # 현재위치 ,돌을 없앤 횟수

    for i in stone:  # 시간복잡도 : O(n)
        distance = i - curr  # 돌과 현재위치 사이의 점프값
        if distance < mid:  # mid 보다 점프값이 짧으면
            delete += 1  # 그 돌을 제거한다 (횟수 up) : O(1)

        else:  # mid 보다 점프값이 길거나 같으면
            curr = i  # 현재위치를 이 돌로 옮기고

            if distance < min_dis:  # O(1)
                min_dis = distance  # 그 mid 에서 최소값인지 확인
        if delete > k:
            break  # k보다 delete 한 횟수가 커지면 안되므로 break 걸어줌

    if delete > k:  # 돌을 없애야하는 k 수 보다 많이 없앤 경우 == mid 값이 너무 큰 경우임
        right = mid - 1  # mid 값을 하나 줄여 돌 없애는 수를 줄임

    else:  # 돌을 딱 맞게 없애거나 더 적게 없앤 경우 == mid 값이 너무 작은 경우임
        result = min_dis  # min_dis 가 결과값!
        left = mid + 1  # mid 값을 하나 늘려 돌을 더 없애거나 mid 값을 최대로 만든다

print(result)  # 결과 출력
