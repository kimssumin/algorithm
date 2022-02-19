#국영수
#sort (key, lambda)


import sys
n = int(sys.stdin.readline()) 
table = [list(sys.stdin.readline().split()) for _ in range(n)] 
table.sort(key = lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0])) 
#-는 내림차순 
for student in table: 
    sys.stdout.write(str(student[0]) + "\n")

