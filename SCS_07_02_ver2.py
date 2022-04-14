# 유사성 검사하기
# 두 수열이 얼마나 유사한지 유사트리플 정의
# P[i] < P[j] < P[k] 이면서 Q[i] < Q[j] < Q[k]인 인덱스 (i, j, k)가 존재
# 유사도는 유사 트리플의 개수로 정의

# BIT(fenwick tree)
import sys


class FenwickTree():
    def __init__(self, N):
        self.N = N
        self.bit = [0 for i in range(N+1)]

    def add(self, index, value):
        index += 1
        while index <= self.N:
            self.bit[index] += value
            index += (index & -index)

    def prefixSum(self, index):
        index += 1
        ans = 0
        while index != 0:
            ans += self.bit[index]
            index -= (index & -index)
        return ans


class Solution:

    def goodTriplets(self, nums1, nums2):
        N = len(nums1)
        fenwick1 = FenwickTree(N)
        fenwick2 = FenwickTree(N)

        # re-index
        indexes = {n: i for i, n in enumerate(nums1)}
        nums2 = [indexes[n] for n in nums2]

        # count increasing triplets
        ans = 0
        for n in nums2:
            if n > 0:
                # count of increasing pairs with second number smaller then n
                cnt = fenwick2.prefixSum(n-1)
                ans += cnt
                # fenwick1.prefixSum(n-1) give us count of numbers smaller than n before
                fenwick2.add(n, fenwick1.prefixSum(n-1))
            # add 1 to number n
            fenwick1.add(n, 1)
        print(ans)
        return ans


input = sys.stdin.readline
n = int(input())
arr_p = list(map(int, input().split()))
arr_q = list(map(int, input().split()))
s = Solution()
result = s.goodTriplets(arr_p, arr_q)
print(result)
