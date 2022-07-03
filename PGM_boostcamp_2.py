
code = [['111111101222201111111'],
        ['100000101222201000001'],
        ['101110100222201011101'],
        ['101110100222201011101'],
        ['101110101222201011101'],
        ['100000101222201000001'],
        ['111111101010101111111'],
        ['000000000222200000000'],
        ['111010101222211101011'],
        ['222222022222222222222'],
        ['222222122222222222222'],
        ['222222022222222222222'],
        ['222222122222222222222'],
        ['000000001222222222222'],
        ['111111100222222222222'],
        ['100000101222222222222'],
        ['101110100222222222222'],
        ['101110100222222222222'],
        ['101110101222222222222'],
        ['100000101102222222200'],
        ['111111101012222222211']
        ]

new_code = []
lst = []
for i in code:
    ii = len(str(i[0]))
    for k in range(ii):
        lst.append(str(i[0][k]))
    new_code.append(lst)
    lst = []
# print(len(new_code[0]))

dic = {' ':  36, '$': 37, ' %':  38,  '*': 39,
       '+': 40, '-': 41, '.': 42, '/': 43, ':': 44}
for i in range(10):
    dic[i] = i
alpha = 10
for i in range(65, 91):
    dic[chr(i)] = alpha
    alpha += 1
# print(dic) ; dic 완성


def down_to_up(s, i, j):
    # new_new_code = new_code
    new_code[i][j] = s[0]
    new_code[i][j-1] = s[1]
    new_code[i-1][j] = s[2]
    new_code[i-1][j-1] = s[3]
    new_code[i-2][j] = s[4]
    new_code[i-2][j-1] = s[5]
    new_code[i-3][j] = s[6]
    new_code[i-3][j-1] = s[7]
    return new_code


def up_to_down(s, i, j):
    new_code[i][j] = s[6]
    new_code[i][j-1] = s[7]
    new_code[i-1][j] = s[4]
    new_code[i-1][j-1] = s[5]
    new_code[i-2][j] = s[2]
    new_code[i-2][j-1] = s[3]
    new_code[i-3][j] = s[0]
    new_code[i-3][j-1] = s[1]

    return new_code


def right_to_left(s, i, j):
    new_code[i][j] = s[0]
    new_code[i][j-1] = s[1]
    new_code[i-1][j] = s[2]
    new_code[i-1][j-1] = s[3]
    new_code[i-1][j-2] = s[4]
    new_code[i-1][j-3] = s[5]
    new_code[i][j-2] = s[6]

    new_code[i][j-3] = s[7]
    return new_code


def left_to_right(s, i, j):
    new_code[i][j] = s[2]
    new_code[i][j-1] = s[3]
    new_code[i-1][j] = s[0]
    new_code[i-1][j-1] = s[1]
    new_code[i-1][j-2] = s[6]
    new_code[i-1][j-3] = s[7]

    new_code[i][j-2] = s[4]
    new_code[i][j-3] = s[5]
    return new_code


def solution(word, error):
    lengths = len(word)
    lengths = bin(lengths).split('0b')[-1]
    cnt = 8 - len(lengths)
    lengths = str('0')*(cnt) + str(lengths)  # 길이 최종

    data = []
    for w in word:
        if w.isalpha():
            w = w.upper()
        ten = dic[w]
        bins = bin(ten).split('0b')[-1]
        cnt = 8 - len(bins)
        bins = str('0')*(cnt) + str(bins)
        data.append(bins)
    cnt = 20 - len(data)
    for i in range(cnt):
        data.append("00000000")
    # print(len(data)) #data 처리 완료

    errors = []
    for i in range(1, 5):
        error1 = int('0x'+str(error)[2*i:2*i + 2], 16)
        error1 = bin(error1).split('0b')[-1]
        cnt = 8 - len(error1)
        error1 = str('0')*(cnt) + str(error1)
        errors.append(error1)
    # print(errors) #error 처리 완료

    answer = []

    # 길이\
    # print(lengths)
    down_to_up(lengths,  18, 20)

    # data1, 6, 7, 12, 13 , 1 4, 1 5
    down_to_up(data[0],  14,  20)
    down_to_up(data[5],  18, 16)
    down_to_up(data[6], 14, 16)  # 7
    down_to_up(data[11], 18, 12)  # 12
    down_to_up(data[12], 14, 12)  # 13
    down_to_up(data[13], 10, 12)
    down_to_up(data[14], 5, 12)

    # data3, 4, 9, 10, 17, 18, 19, 20
    up_to_down(data[2], 14, 18)
    up_to_down(data[3], 18, 18)
    up_to_down(data[8], 14, 14)
    up_to_down(data[9], 18, 14)
    up_to_down(data[16], 5, 10)
    up_to_down(data[17], 10, 10)
    up_to_down(data[18], 14,  10)
    up_to_down(data[19], 18,  10)

    # data 2, 8, 16
    right_to_left(data[1], 10, 20)
    right_to_left(data[7], 10, 16)
    right_to_left(data[15], 1, 12)

    # data 5, 11
    left_to_right(data[4], 20, 18)
    left_to_right(data[10], 20, 14)

    # error
    down_to_up(errors[0], 12, 8)
    down_to_up(errors[2], 12, 3)
    up_to_down(errors[1], 12, 5)
    up_to_down(errors[3], 12, 1)
    # answer = new

    cnt = 0
    for i in new_code:
        # print(i)
        answer.append("".join(i))
    return answer
