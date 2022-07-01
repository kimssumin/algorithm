# 2021 kakao blind recruitment
# 순위검색

from itertools import combinations
from bisect import bisect_left


def solution(info, query):
    answer = []
    info_dict = {}
    for i in info:
        my_key = i.split(" ")[:-1]
        my_value = i.split(" ")[-1]
        #my_key = "".join(my_key)
        for j in range(5):
            for c in combinations(my_key, j):
                tmp = "".join(c)
                if tmp in info_dict:
                    info_dict[tmp].append(int(my_value))
                else:
                    info_dict[tmp] = [int(my_value)]
    for k in info_dict:
        info_dict[k].sort()

    for q in query:
        query_key = q.split(" ")[:-1]
        query_num = int(q.split(" ")[-1])
        query_key = "".join(query_key)
        query_key = query_key.replace('and', "")
        query_key = query_key.replace("-", "")
        # print(query_key)
        if query_key in info_dict:
            scores = info_dict[query_key]
            l = bisect_left(scores, query_num)
            answer.append(len(scores) - l)
        else:
            answer.append(0)
    return answer
