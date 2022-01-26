#오르막수
#DP
#nHr = n+r-1Cr

import math

n = int(input())
print(math.comb(9 + n, n) % 10007)
