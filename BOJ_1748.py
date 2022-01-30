#수 이어쓰기 1
#brute force

n = int(input())
length = len(str(n))
i , cnt =0, 0
st = length-1

while i < st :
    cnt += 9 * (10**i) * (i+1)
    i += 1

cnt += (n - (10 ** st) + 1) * (length)

print(cnt)