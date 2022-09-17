# 1차원 폭발 게임
# simulation

n, m = map(int, input().split())
bomb = []
for _ in range(n):
    bomb.append(int(input()))


def game():
    cnt = 1
    temp = bomb[0]
    start_index = 0
    lists = []

    for i in range(1, len(bomb)):
        if bomb[i] == temp:
            cnt += 1
            # print(cnt)
            if i == len(bomb)-1 and cnt >= m:
                lists.append([start_index, len(bomb)])
        else:
            if cnt >= m:
                lists.append([start_index, i])
                temp = bomb[i]
                cnt = 1
                start_index = i
            else:
                temp = bomb[i]
                cnt = 1
                start_index = i
    # print(lists)
    cal = 0
    for k in range(len(lists)):
        if k != len(lists)-1:
            del bomb[lists[k][0]:lists[k][1]]
            cal += lists[k][1] - lists[k][0]
            for a in range(2):
                lists[k+1][a] -= cal
        else:
            del bomb[lists[k][0]:lists[k][1]]
            # print(lists)
# print(bomb)


def check():
    if (len(bomb) == 0):
        return False

    cnt = 1
    count = []
    temp = bomb[0]

    for i in range(1, len(bomb)):
        if bomb[i] == temp:
            cnt += 1
            if i == len(bomb)-1:
                count.append(cnt)
        else:
            count.append(cnt)
            cnt = 1
            temp = bomb[i]

    for j in count:
        if j >= m:
            return True
    return False


if m == 1:
    print(0)
else:
    while(1):
        if check():
            game()

        else:
            print(len(bomb))
            if (len(bomb) != 0):
                for k in bomb:
                    print(k)
            break
