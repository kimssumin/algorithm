#두 배열의 원소교체
#원소의 합이 최대로(A)

N, K = map(int, input().split())
a  = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse = True)


for i in range(K):
    if a[i] < b[i]:
        a[i],b[i] = b[i],a[i]
    else:
        break

print(sum(a))