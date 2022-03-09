# 배열 + 스캔 오르락내리락
# n개의 원소를 가진 배열 A 를 입력으로 받았을 때 B[0] <= B[1] >= B[2] <= B[3] ...이 만족하도록 B를 만들어라
# solve 함수는 A를 입력으로 받아 B를 리턴
# check 함수는 B가 조건에 맞는지 결과를 출력

# 시간복잡도 O(NlogN)

def solve(A):
    # return a list B such that B[0] <= B[1] >= B[2] <= B[3] ...
    A.sort(reverse=True)  # 시간복잡도 O(NlogN)
    n = len(A)  # O(1)
    res = []
    move = n//2
    sec = A[:move-1]  # O(n)
    fir = A[move:]  # O(n)
    for i in range(move+1):  # O(n)
        if len(fir) == 0 or len(sec) == 0:
            break
        x = fir.pop()  # O(1)
        y = sec.pop()  # O(1)
        res.append(x)  # O(1)
        res.append(y)  # O(1)
        return res
