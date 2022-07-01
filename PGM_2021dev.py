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
        print(lists)
        answer.append(min(lists))

    return answer


print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]))

'''
def solution(rows, columns, queries):
    answer = []

    graph = [list(range(1 + (i * columns), 1 + (i * columns) + columns)) for i in range(rows)]

    for query in queries:
        x1, y1, x2, y2 = query
        temp = graph[x1 - 1][y2 - 1]
        temp1 = graph[x2 - 1][y2 - 1]
        temp2 = graph[x2 - 1][y1 - 1]        
        ans = min(temp, temp1, temp2)
        for i in range(y2 - 1, y1 - 1, -1):
            graph[x1 - 1][i] = graph[x1 - 1][i - 1]
            ans = min(ans, graph[x1 - 1][i])

        for i in range(x2 - 1, x1, - 1):
            graph[i][y2 - 1] = graph[i - 1][y2 - 1]
            ans = min(ans, graph[i][y2 - 1])


        for i in range(y1 - 1, y2 - 1):
            graph[x2 - 1][i] = graph[x2 - 1][i + 1]
            ans = min(ans, graph[x2 - 1][i])

        for i in range(x1 - 1 , x2 - 2):
            graph[i][y1 - 1] = graph[i + 1][y1 - 1]
            ans = min(ans, graph[i][y1 - 1])
        graph[x1][y2 - 1] = temp
        graph[x2 - 1][y2 - 2] = temp1
        graph[x2 - 2][y1 - 1] = temp2
        answer.append(ans)

    print(answer)

    return answer '''
