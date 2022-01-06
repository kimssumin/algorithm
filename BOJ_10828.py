#스택

import sys

stack = []

N = int(input())
for _ in range (N):
    input = sys.stdin.readline()
    do = str(input)
    if do.startswith("push"):
        num = do.split()[-1]
        stack.append(num)
    elif do.startswith("pop"):
        if len(stack) == 0:
            print(-1)
        else :
            print(stack.pop())
    elif do.startswith("size"):
        print(len(stack))
    elif do.startswith("empty"):
        if len(stack)==0 : 
            print (1)
        else:
            print(0)
    elif do.startswith("top"):
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])
    