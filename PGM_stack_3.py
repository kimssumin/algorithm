# 다리를 지나는 트럭
from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    trucks_on_bridge = [0] * bridge_length
    trucks_on_bridge = deque(trucks_on_bridge)
    truck_weights = deque(truck_weights)
    while len(trucks_on_bridge):
        answer += 1
        trucks_on_bridge.popleft()
        if truck_weights:
            if sum(trucks_on_bridge) + truck_weights[0] <= weight:
                trucks_on_bridge.append(truck_weights.popleft())
            else:
                trucks_on_bridge.append(0)

    return answer


print(solution(2, 10, [7, 4, 5, 6]))
