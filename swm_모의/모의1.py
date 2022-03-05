# 괄호수 맞추는 문제


def main():
    b = list(input())
    all = len(b)
    b.sort()

    for i in range(1, len(b)):
        if b[i] == ')':
            cnt = i
            break
        else:
            cnt = 0

    if 2 <= all <= 50:
        if cnt == all // 2 and all % 2 == 0:
            x = 'YES'
        else:
            x = 'NO'
        print(x)


if __name__ == "__main__":
    main()
