def main():
    num = list(map(int, input().split()))
    n = int(input())
    for i in range(1, n+1):
        x, y, z = map(int, input().split())
        num.append(x)
        num.append(y)
        num.append(z)
        num.sort()
        print(num[i], num[(2*i)+1])


if __name__ == "__main__":
    main()

#삼분값
