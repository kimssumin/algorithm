#요세푸스 문제_큐
# 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열

N, K = map(int, input().split())
q = [i for i in range(1,N+1)]
yo = []

while(q):
    for i in range(K-1):
        q.append(q.pop(0))
    yo.append(str(q.pop(0)))
print("<", ", ".join(yo), ">", sep="")

'''from collections import deque
n,k = map(int,input().split())
q = deque([i+1 for i in range(n)])

r = []
while(q):
    r.append(str(q.popleft()))
print("<", ", ".join(r),">", sep="")'''

