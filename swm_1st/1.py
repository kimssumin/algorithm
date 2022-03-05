import sys

input = sys.stdin.readline


def main():
    n = int(input())
    k = []
    w = []
    fin = []
    for _ in range(n):
        k.append(input().rstrip())
    t = int(input())
    for _ in range(t):
        word = input().rstrip()
        cnt = 0
        w.append(word)
        for i in k:
            if i.startswith(word):
                cnt += 1
        fin.append(cnt)

    for j in fin:
        print(j)


if __name__ == "__main__":
    main()

#키워드 자동완성
