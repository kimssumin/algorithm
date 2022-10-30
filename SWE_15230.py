# 알파벳 공부
answer = [chr(i) for i in range(97,123)]
T = int(input())
for test_case in range(1, T + 1):
    inputs = list(input())
    cnt = 0
    for i,alpha in enumerate(inputs):
        if alpha != answer[i]:
            break
        else:
            cnt += 1
    print('#'+str(test_case)+' ' +str(cnt))