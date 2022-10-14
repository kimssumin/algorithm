from collections import deque


def solution(cacheSize, cities):
    answer = 0
    cache = deque([])
    if cacheSize == 0:
        answer = len(cities)*5
    else:
        for city in cities:
            city = city.lower()
            if city in cache:
                answer += 1
                cache.remove(city)
                cache.append(city)
            else:
                if(len(cache) == cacheSize):
                    #교체필요
                    cache.popleft()
                    cache.append(city)
                    answer += 5
                else:
                    cache.append(city)
                    answer += 5
    return answer
