def solution(msg):
    answer = []
    dic = [0]
    for i in range(65, 91):
        dic.append(chr(i))
    max_len = 1
    while(1):
        if (len(msg) == 0):
            break
        if max_len <= len(msg):
            for k in range(max_len, 0, -1):
                let = msg[:k]
                if let in dic:
                    answer.append(dic.index(let))
                    if(k != len(msg)):
                        max_len = max(max_len, k+1)
                        dic.append(msg[:k+1])
                    #print(max_len, dic)
                    msg = msg[k:]
                    break
                else:
                    continue
        else:
            max_len = len(msg)
            for k in range(max_len, 0, -1):
                let = msg[:k]
                if let in dic:
                    answer.append(dic.index(let))
                    if(k != len(msg)):
                        max_len = max(max_len, k+1)
                        dic.append(msg[:k+1])
                    #print(max_len, dic)
                    msg = msg[k:]
                    break
                else:
                    continue

    # print(dic)
    return answer
