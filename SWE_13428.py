from itertools import combinations

T = int(input())
for test_case in range(1, T+1):
    N = list(x for x in input())
    target = [i for i in range(len(N))]

    min_num, max_num = int(''.join(N)), int(''.join(N))

    for value in combinations(target, 2):
        i, j = value
        N[i], N[j] = N[j], N[i]
        if N[0] == '0':
            N[i], N[j] = N[j], N[i]
            continue
        if int(''.join(N)) < min_num:
            min_num = int(''.join(N))
        if int(''.join(N)) > max_num:
            max_num = int(''.join(N))
        N[i], N[j] = N[j], N[i]

    print(f'#{test_case} {min_num} {max_num}')
