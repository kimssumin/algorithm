# 치맥
# lambda sort

#시간복잡도 : O(N^2)

def solve(a, b, t):
    a_max = t // a  # 최대로 들어갈 수 있는 몫을 구한다(즉 치킨의 갯수)
    b_max = t // b  # 최대로 들어갈 수 있는 몫을 구한다(즉 치킨의 갯수)
    for i in range(0, a_max + 1):  # O(N^2) 시간복잡도
        for j in range(0, b_max + 1):
            if t-((a * i) + (b * j)) >= 0:  # 맥주를 먹어야하는 시간이 0분 이상일때만
                # answer 리스트에 [먹은 치킨의 갯수, 남은 시간]을 append 한다
                answer.append([i + j, t-((a * i) + (b * j))])
    # O(NlogN)의 시간복잡도, 우선적으로 맥주먹는 시간이 적은 순으로 정렬 후, 치킨 먹는 갯수가 많은 순으로 정렬함
    answer.sort(key=lambda x: (x[1], -x[0]))
    if answer[0][1] != 0:  # 맥주를 마셔야할때는 맥주를 먹는 시간이 가장 적으면서 치킨을 가장 많이 먹을 수 있는 경우의
        print(answer[0][0], answer[0][1])  # 먹은 치킨 갯수와 남은 시간을 출력
    elif answer[0][1] == 0:  # 치킨만으로 시간을 꽉 채울 수 있을 때엔
        print(answer[0][0])  # 그때의 먹은 치킨의 갯수만을 출력


a, b, t = [int(x) for x in input().split()]
answer = []  # 정답을 저장할 리스트
solve(a, b, t)
