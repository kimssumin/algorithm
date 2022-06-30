# 행렬 테두리 회전하기

def solution(rows, columns, queries):
    answer = []
    table = []
    for i in range(rows):
        table.append([j + 1 + (rows*i) for j in range(columns)])

    for que in queries:
        lists = []
        table_correct = table
        s_r = que[0]
        s_c = que[1]
        e_r = que[2]
        e_c = que[3]
        for k in range(s_r-1, e_r):
            lists.append(table[k][s_c-1])
            lists.append(table[k][e_c-1])
            if k == s_r-1:
                table_correct[k][s_c] = table[k][s_c-1]
                table_correct[k+1][e_c-1] = table[k][e_c-1]

            else:
                table_correct[k-1][s_c-1] = table[k][s_c-1]
                table_correct[k+1][e_c-1] = table[k][e_c-1]
                if k == e_r-1:
                    table_correct[k][e_c-2] = table[k][e_c-1]

        for kk in range(s_c, e_c-1):
            lists.append(table[s_r-1][kk])
            lists.append(table[e_r-1][kk])
            table_correct[s_r-1][kk+1] = table[s_r-1][kk]
            table_correct[e_r-1][kk-1] = table[e_r-1][kk]
        table = table_correct
        answer.append(min(lists))

    return answer
