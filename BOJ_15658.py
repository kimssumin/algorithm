#연산자 끼워넣기 (2)
#brute force

n = int(input())
a = list(map(int, input().split()))
ad, s, m, d = list(map(int, input().split()))
mx, mn = -1e9, 1e9 

def solve(index, ans, add, sub, mul, div) :
    global mx, mn
    if index >= n :
        mx = max(mx, ans)
        mn = min(mn, ans)
        return
        
    if add > 0 :
        solve(index+1, ans+a[index], add-1, sub, mul, div)
    if sub > 0 :
        solve(index+1, ans-a[index], add, sub-1, mul, div)
    if mul > 0 :
        solve(index+1, ans*a[index], add, sub, mul-1, div)
    if div > 0 :
        solve(index+1, ans//a[index] if ans > 0 else -((-ans)//a[index]), add, sub, mul, div-1)

solve(1, a[0], ad, s, m, d)
print(mx)
print(mn)