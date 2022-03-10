# max 연산을 지원하는 스택만들기
# push, pop 연산은 모두 O(1) 시간에 동작, max 연산은 평균적으로 O(1) 시간에 동작
# 스택 최대 2개 사용해 구현 가능

# UTF-8 encoding when using korean

class MaxStack:  # Max값을 찾기위한 클래스 정의
    def __init__(self):
        self.items = []  # 원소들을 담을 리스트 선언
        self.maxitems = []  # max items를 담을 리스트 선언
        self.max_val = 0  # 초기 max 값을 0으로 설정

    def push(self, val):
        if val >= self.max_val:  # 새로 push 된 원소가 현재 max 값보다 크다면
            # maxitems 에 append -> 시간 복잡도 : O(1)
            self.maxitems.append(val)
            self.max_val = val  # 현 max 값 업데이트
        self.items.append(val)  # 원소를 담을 리스트에 append(push) -> 시간 복잡도 : O(1)

    def pop(self):
        if len(self.items) == 0:  # 리스트가 비었을 때
            print("EMPTY")  # empty 출력
            return None  # pop 할 원소는 없음
        else:
            x = self.items.pop()  # pop 연산 -> 시간복잡도 : O(1)
            # 만약 pop 하는 원소가 현 최댓값이라면
            if x == self.max_val and len(self.items) != 0:
                self.maxitems.pop()  # 현 최댓값은 제거하고 (시간복잡도 O(1))
                # 그 다음 최댓값을 현 최댓값으로 업데이트 (O(1))
                self.max_val = self.maxitems[-1]
            print(x)

    def Max(self):
        if len(self.items) == 0:  # 스택이 비었다면
            print("EMPTY")  # empty 출력
            return None
        else:
            print(self.max_val)  # 저장된 최댓값 프린트
            return self.max_val


S = MaxStack()  # 정의한 클래스 불러오기

while 1:  # exit 입력이 들어오기 전까지 반복

    do = input()
    if do.startswith('push'):  # push 입력이 들어왔을 때
        x = int(do.split()[1])  # 공백 기준 오른쪽에 위치한 value인 정수를 넣어
        S.push(x)  # push 연산을 수행
    elif do.startswith('pop'):  # pop 입력이 들어왔을 때 pop 연산을 수행
        S.pop()
    elif do.startswith('max'):  # pop 입력이 들어왔을 때 pop 연산을 수행
        S.Max()
    elif do.startswith('exit'):  # 연산 처리를 끝낸다
        break
