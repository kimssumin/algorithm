# 크레인 인형뽑기
def solution(board, moves):
    answer = 0
    bagu = []
    move = [i-1 for i in moves]
    for i in move:
        for j in range(len(board)):
            if board[j][i] != 0:
                if len(bagu) != 0 and bagu[-1] == board[j][i]:
                    bagu.pop()
                    board[j][i] = 0
                    answer += 2
                else:
                    bagu.append(board[j][i])
                    board[j][i] = 0
                break

    return answer
