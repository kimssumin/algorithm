from itertools import combinations as com


def main():
    n = input()
    cal = list(map(int, input().split()))
    cnt = 0

    for i in range(n):
        x = list(com(cal, i))
        for j in x:
            if 2000 <= sum(int(j)) <= 2500:
                cnt += 1

    print(cnt)


if __name__ == "__main__":
    main()

# 칼로리
