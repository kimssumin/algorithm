import heapq


def solution(jobs):
    sums = 0
    now, i = 0, 0
    start = -1e9
    controller = []
    while i < len(jobs):
        for task in jobs:
            if start < task[0] <= now:
                heapq.heappush(controller, [task[1], task[0]])
        if len(controller) > 0:
            curr = heapq.heappop(controller)
            start = now
            now += curr[0]
            sums += (now - curr[1])
            i += 1
        else:
            now += 1
    return sums // len(jobs)
