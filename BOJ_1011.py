#수열

T = int(input())

for i in range(T):
    x, y = map(int,input().split())
    distance = y - x
    count = 0  # 이동 횟수
    move = 1  # count별 이동 가능한 거리
    move_sum = 0  # 이동한 거리의 합
    while move_sum < distance :
        count += 1
        move_sum += move  # count 수에 해당하는 move를 더함
        if count % 2 == 0 :  # count가 2의 배수일 때, 
            move += 1  
    print(count)
