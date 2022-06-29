# 문자열 압축

def solution(s):
    result = []
    prints = []
    ans = 0

    length = len(s)
    for l in range(1, length):
        answer = ""
        #l : 자르는 단위개수
        if length % l == 0:
            cut = length // l
        else:
            cut = (length // l) + 1
        save = s[0: l]
        cnt = 1
        for i in range(1, cut+1):
            start = i * l
            end = start + l
            if end > length:
                end = length
            #print(start, end)
            if save == s[start:end]:
                cnt += 1
            else:
                if cnt >= 2:
                    answer += str(cnt) + save
                    save = s[start:end]
                    cnt = 1

                else:
                    answer += save
                    save = s[start:end]
                    cnt = 1
                #print(answer)
        result.append(len(answer))
        prints.append(answer)

    #print(prints)
    ans = min(result)

    return ans
