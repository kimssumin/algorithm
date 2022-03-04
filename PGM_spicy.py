# 더 맵게
# 힙

import heapq
from telnetlib import KERMIT


def solution(scoville, K):
    heap = []
    for num in scoville:
        heapq.heappush(heap, num)
    mix_cnt = 0
    while heap[0] < K:
        try:
            heapq.heappush(heap, heapq.heappop(
                heap) + (heapq.heappop(heap) * 2))
        except IndexError:
            return -1
        mix_cnt += 1

    answer = 0
    return answer
