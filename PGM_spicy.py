from heapq import *


def solution(scoville, K):
    count = 0
    heapify(scoville)  # 리스트를 힙으로

    while scoville[0] < K and len(scoville) > 1:
        num1 = heappop(scoville)
        num2 = heappop(scoville)
        heappush(scoville, num1 + num2 * 2)
        count += 1
    return count if scoville[0] >= K else -1
