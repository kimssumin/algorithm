# 치맥
#

def solve(a, b, t):

    # O(1)의 시간복잡도
    if a > b:  # a, b 중 큰 값과 작은 값을 찾는다 -> 치킨 갯수를 많게하려면 큰 값의 갯수를 작게해야함
        max_ = a
        min_ = b
    else:
        max_ = b
        min_ = a

    # 시간복잡도 상으로는 O(n^3)이지만 실질적으로 O((t//max + 1)  + ((t-i) // max_ + 1)(t - (t // max)) 정도의 시간이라 오래걸리지 않음
    for i in range(t // max_ + 1):  # 큰 수가 나누어떨어질때까지(혹은 근접) 가장 작은 수부터 하나씩 늘림
        if ((t - (max_ * i)) % min_) == 0:  # 나누어 떨어지면
            # O(1) ; i(먹는데 오래걸리는 치킨의 갯수) + (먹는데 적게걸리는 치킨 갯수)
            ans1 = i + ((t - (max_ * i)) // min_)
            print(ans1)
            break
        else:
            if i == (t // max_):  # for 문을 다 돌았지만 정확히 딱 맞출 수 없는 경우
                mac_a = t % a
                mac_b = t % b
                # 치킨 한 종류로 최대한 먹고 남은 시간 맥주를 먹는 경우 O(1)시간
                if mac_a < mac_b:
                    minn = mac_a
                    num = t // a
                else:
                    minn = mac_b
                    num = t // b
                xx = 1e9
                ii = 1e9
                if minn == 1:  # 남은 시간이 1분 이하인 경우는 없기때문에 위의 경우에서 minn == 1이면 그 경우를 출력
                    print(num, minn)
                else:  # 아닌 경우
                    # 남은 시간을 1분	부터 minn 이하까지 반복 -> 그 이상의 경우는 의미없이 위의 경우가 가장 많이 치킨을 먹게됨
                    for i in range(1, minn):
                        for j in range((t-i) // max_ + 1):
                            if ((t-i - (max_ * j)) % min_) == 0:
                                xx = ((t-i - (max_ * j)) // min_) + j
                                ii = i
                                # 남은 시간을 빼서 다시 위의 과정을 반복했을때 나누어떨어지는 경우 minn 값보다 작으면서 가장 많이 치킨을 먹게되므로 출력
                                print(xx, ii)
                                break
                            else:
                                if i == minn - 1:  # 다 돌아도 경우가 없으면
                                    # minn 값이 최대로 오래 치킨을 먹을 수 있는 경우
                                    print(num, minn)


a, b, t = [int(x) for x in input().split()]
solve(a, b, t)
