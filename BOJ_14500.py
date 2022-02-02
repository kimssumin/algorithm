#테트로미노
#brute force

#시간초과됨!

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

#테트로미노 경우의 수를 전부 입력.. 별로 똑똑한 방법은 아닌거같다
shapes = [[(0,0),(0,1),(0,2),(0,3)], [(0,0),(1,0),(2,0),(3,0)], [(0,0),(0,1),(1,0),(1,1)], [(0,0),(1,0),(2,1),(2,1)], [(0,1),(1,1),(2,1),(2,0)],[(0,0),(0,1),(0,2),(1,0)],[(0,0),(0,1),(0,2),(1,2)],[(0,0),(1,0),(2,0),(0,1)], [(0,1), (1,1),(2,1),(0,0)],[(0,0),(1,0),(1,1), (1,2)], [(0,2),(1,2),(1,1),(1,0)], [(0,0),(1,0),(1,1),(2,1)], [(0,1),(1,1),(1,0),(2,0)], [(0,0),(0,1),(1,1),(1,2)], [(1,0),(1,1),(0,1),(0,2)], [(0,0),(0,1),(0,2),(1,1)], [(0,1),(1,0),(1,1),(1,2)], [(1,0),(0,1),(1,1),(2,1)], [(0,0),(1,0),(1,1),(2,0)]]

answer = 0

for i in range(n):
    for j in range(m):
        for shape in shapes:
            temp = 0
            for s in shape:
                if 0 <= i + s[0] < n and 0 <= j + s[1] < m:
                    temp += board[i + s[0]][j + s[1]]
            answer = max(answer, temp)

print(answer)