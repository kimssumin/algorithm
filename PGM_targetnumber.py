#DFS/BFS
#DFS 풀이
#타겟넘버 Level2

def solution(numbers, target):
    n = len(numbers)
    answer = 0
    def dfs(idx, result):
        if idx == n:
            if result == target:
                nonlocal answer #solution 에 영향미침
                answer += 1
            return
        else:
            dfs(idx+1, result + numbers[idx])
            dfs(idx+1, result - numbers[idx])
    dfs(0,0)
            
    return answer