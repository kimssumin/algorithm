def solution(n, plans, clients):
    answer = []

    def check():
        service = []
        for i in range(len(plans)):
            data = int(plans[i].split(' ')[0])
            service_append = list(map(int, plans[i].split(' ')))[1:]
            service += service_append

            cnt = 0
            if data_c <= data:
                for k in service_c:
                    if k in service:
                        cnt += 1
                if cnt == len(service_c):
                    return i+1
                else:
                    if i == len(plans) - 1:
                        return 0

            elif i == len(plans) - 1:
                return 0

    for j in range(len(clients)):
        data_c = int(clients[j].split(' ')[0])
        service_c = list(map(int, clients[j].split(' ')))[1:]
        answer.append(check())

    return answer
