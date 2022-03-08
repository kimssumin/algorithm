# 스택 2개로 큐 구현하기
# dequeue, enqueue 연산 모두 시간복잡도 O(1)로 해야함


class myQueue:  # 스택을 이용하여 큐 클래스를 정의 (스택은 리스트를 이용함)
    def __init__(self):
        self.items = []  # 원소를 담을 리스트
        self.front_index = 0  # 인덱스 번호 초기화 (0)

    def enqueue(self, val):  # enq 입력이 들어올 때
        # 리스트에 append -> 시간 복잡도 : O(1) (append 연산이기 때문에)
        self.items.append(val)

    def dequeue(self):  # deq 입력이 들어올 때
        if self.front_index == len(self.items):  # 리스트의 길이가 0일때, 즉 리스트가 비었을 때
            print("EMPTY")  # empty 출력
            return None  # deq 할 원소는 없음
        else:
            # index로 원소에 바로 접근하는 방식은 시간복잡도가 O(1)
            x = self.items[self.front_index]
            # index를 하나 뒤로 이동 -> 다음 deq 입력이 들어왔을때 O(1)의 시간에 동작할 수 있게 함
            self.front_index += 1
            print(x)  # deq 한 값인 x 를 출력
            return x  # x를 deq함


Q = myQueue()  # 정의한 클래스 불러오기

while 1:  # exit 입력이 들어오기 전까지 반복
    do = input()
    if do.startswith('enq'):  # enq 입력이 들어왔을 때
        x = do.split()[1]  # 공백 기준 오른쪽에 위치한 value인 정수를 넣어
        Q.enqueue(x)  # enqueue 연산을 수행
    elif do.startswith('deq'):  # deq 입력이 들어왔을 때 dequeue 연산을 수행
        Q.dequeue()
    elif do.startswith('exit'):  # 연산 처리를 끝낸다
        break
