import sys
input = sys.stdin.readline


def main():

    n, q = map(int, input().split())
    level = [[0, 0]]
    lv = 1
    memory = 0
    c = list(map(int, input().split()))
    cnt = 0
    curr = c[cnt]

    for _ in range(q):
        inp = list(map(str, input().split()))
        if len(inp) == 3:  # insert 연산 수행
            k = int(inp[1])
            s = int(inp[2])
            memory += s

            change = False
            for i in level:
                if i[0] == k:
                    ii = i
                    change = True
                    break

            if change == True:
                memory -= ii[1]
                ii[1] = s

            else:
                level.append([k, s])

            if memory > curr:
                if cnt == n:
                    lv = n
                    break
                lv += 1
                cnt += 1
                curr = c[cnt]

            elif memory < curr and cnt >= 1:
                lv -= 1
                cnt -= 1
                curr = c[cnt]

        else:  # find 연산 수행
            k = int(inp[1])
            res = False
            for a in level:
                if a[0] == k:
                    res = True
                    break
            if res == True:
                print(lv, a[1])
            else:
                print('none')

    # print(x)


if __name__ == "__main__":
    main()

#산사태셋 #
