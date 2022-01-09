#두 배열의 원소교체
#K번동안만 for문을 돌리고 두 원소를 비교하는 if 문을 작성
#정렬

n, k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a = sorted(a)
b = sorted(b, reverse = True)

for i in range(k):
    if a[i] < b[i]:
        a[i], b[i] = b[i], a[i]
    else:
        break

print(f'a = {a}')
print(f'b = {b}')

print(sum(a))