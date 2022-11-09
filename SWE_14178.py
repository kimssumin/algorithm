T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, d = map(int, input().split())
    range = 2*d + 1
    if n % range == 0:
        answer = n // range
    else:
        answer = (n // range) + 1
    print('#'+str(test_case)+' '+str(answer))
