T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.


def check1(n, m, pann):
    for i in range(n):
        for j in range(m):
            if pann[i][j] == '?':
                continue
            else:
                if (i + j) % 2 == 0 and pann[i][j] != '#':
                    return False
                elif (i + j) % 2 != 0 and pann[i][j] != '.':
                    return False
    return True


def check2(n, m, pann):
    for i in range(n):
        for j in range(m):
            if pann[i][j] == '?':
                continue
            else:
                if (i + j) % 2 == 0 and pann[i][j] != '.':
                    return False
                elif (i + j) % 2 != 0 and pann[i][j] != '#':
                    return False
    return True


for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    pann = []
    for _ in range(n):
        pann.append(list(input()))
    if check1(n, m, pann) or check2(n, m, pann):
        print('#'+str(test_case)+' possible')
    else:
        print('#'+str(test_case)+' impossible')
