#리모컨
#brute force

n = int(input())
m = int(input())
cnt = abs(100 - n) # +, -로 이동 가능한 경우
if m != 0 :
    exc = set(input().split())
else:
    exc = set()


for num in range(1000001):
    for i in str(num):
        if i in exc: #번호를 눌러서 이동 못하는 경우
            break #마지막 자릿수까지 모두 사용가능한 버튼이라면
    else:
        cnt = min(cnt, len(str(num)) + abs(num - n))

print(cnt)