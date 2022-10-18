def solution(s):
    stack = []
    for g in s:
        if g == '(':
            stack.append('(')
        elif g == ')' and len(stack) != 0:
            stack.pop()
        elif g == ')' and len(stack) == 0:
            return False
        # print(stack)

    if len(stack) == 0:
        answer = True
    else:
        answer = False
    return answer

