#왕실의 나이츠, 구현 알고리즘
#이동빈 저, 이것이 코딩테스트다 중

ori = list(input())
col = int(ord(ori[0])) - 96
row = int(ori[1])
cnt = 0

x = [-2, -2, 2, 2, -1, -1, 1, 1]
y = [-1, 1, -1, 1, -2, 2, -2, 2]

for i in range(8):
    nx = col + x[i]
    ny = row + y[i]

    if nx > 0 and ny > 0 and nx <= 8 and ny <= 8:
        cnt += 1

print(cnt)