all = []

for _ in range(3):
    name = input("이름 : ")
    phone = input("전화 : ")
    all.append({'name': name, 'tel': phone})

while(1):
    num = int(input("1. 검색 2. 종료 :"))
    if num == 2:
        for j in all:
            print(j)
        break
    elif num == 1:
        yes = 0
        search = input("검색할 이름 : ")
        for i in all:
            if i['name'] == search:
                print(search, ":", i['tel'])
                yes += 1
                break
            else:
                continue
        if yes == 0:
            print(search+"의 전화번호는 저장되어 있지 않습니다!")
    else:
        print("잘못된 번호를 입력함!!")
