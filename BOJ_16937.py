# 두 스티커
# bruteforce

h, w = map(int, input().split())
n = int(input())
size = []
ans = 0

for _ in range(n):
    size.append(list(map(int, input().rstrip().split())))

for i in range(n):
    r1, c1 = size[i][0], size[i][1]
    s1 = r1*c1
    for j in range(i+1, n):
        r2, c2 = size[j][0], size[j][1]
        s2 = r2*c2

        if (r1 + r2 <= h and max(c1, c2) <= w) or (max(r1, r2) <= h and c1+c2 <= w):
            ans = max(ans, s1+s2)
        elif(r1 + c2 <= h and max(c1, r2) <= w) or (max(r1, c2) <= h and c1+r2 <= w):
            ans = max(ans, s1+s2)
        elif(c1 + r2 <= h and max(r1, c2) <= w) or (max(c1, r2) <= h and r1+c2 <= w):
            ans = max(ans, s1+s2)
        elif(c1 + c2 <= h and max(r1, r2) <= w) or (max(c1, c2) <= h and r1+r2 <= w):
            ans = max(ans, s1+s2)

print(ans)
