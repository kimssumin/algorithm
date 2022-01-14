#미래도시
#그래프, 플로이드워셔문제

INF = int(1e9)
n, m = map(int, input().split())
graph = [[INF]*(n+1) for _ in range(n+1)] #2차원 리스트를 만들고, 모든 값을 무한으로 초기화

for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            graph[a][b] == 0

for _ in range(m): #각 간선에 대한 정보 입력, 초기화
    a, b = map(int, input().split())
    graph[a][b] == 1
    graph[b][a] == 1 # 서로에게 가는 비용은 1 로 초기화

x, k = map(int, input().split()) #거쳐갈 노드 k와 최종목적지x

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

distance = graph[1][k] + graph[k][x]

if distance >= INF:
    print("-1")
else:
    print(distance)