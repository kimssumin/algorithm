#큐

from collections import deque
import sys

queue = deque()
N = int(input())

for _ in range (N):
    inputs = sys.stdin.readline()
    do = str(inputs)
    if do.startswith("push"):
        n = do.split()[-1]
        queue.append(n)
    elif do.startswith("front"):
        if len(list(queue)) == 0:
            print(-1)
        else :
            print(list(queue)[0])
    elif do.startswith("back"):
        if len(list(queue)) == 0:
            print(-1)
        else :
            print(list(queue)[-1])
    elif do.startswith("size"):
        print(len(list(queue)))
    elif do.startswith("empty"):
        if len(list(queue)) == 0 :
            print(1)
        else :
            print(0)
    elif do.startswith("pop"):
        if len(list(queue)) == 0:
            print(-1)
        else:
            print(queue.popleft())