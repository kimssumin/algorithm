T = int(input())
for test_case in range(1, T+1):
    log = list(input())
    loss_cnt = log.count('x')
    if loss_cnt <= 7:
        print('#'+str(test_case)+' YES')
    else:
        print('#'+str(test_case)+' NO')
