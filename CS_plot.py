#독살의 음모
#고급문제해결 _몸풀기1

import random

wine = [0] * 8
poi = random.randint(0,7)
wine[poi] = 1

test1 = wine[0] + wine[1]
test2 = wine[2] + wine[3]
test3 = wine[4] + wine[5]
test4 = wine[0] + wine[2] + wine[4] + wine[6]

if test1 == 1 and test4 == 1:
    print("1번 와인")
elif test1 == 1 and test4 == 0 :
    print("2번 와인")
elif test2 == 1 and test4 == 1:
    print("3번 와인")
elif test2 == 1 and test4 == 0:
    print("4번 와인")
elif test3 == 1 and test4 == 1:
    print("5번 와인")
elif test3 == 1 and test4 == 0:
    print("6번 와인")
elif test4 == 1 and test1 == 0 and test2 == 0 and test3==0:
    print("7번 와인")
else:
    print("8번 와인")

'''
왕이 마실 8병 중 한병에 강력한 독, 한방울만 있어도 치명적
섞여있으면 무조건 검출됨
검사시간은 1시간이 걸리는데, 왕이 무조건 1시간 후에 와인을 마실테니 독이 든 병을 찾아내라는 명령내림
최소 몇대의 검사장비가 있어야할까? (와인은 섞어서 검사가능하다)
'''