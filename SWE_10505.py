T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    payment = list(map(int, input().split()))
    avg = sum(payment) / len(payment)
    cnt = 0
    for i in payment:
        if i <= avg:
            cnt += 1
    print('#' + str(test_case) + ' ' + str(cnt))
