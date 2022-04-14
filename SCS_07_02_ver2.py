# 유사성 검사하기
# 두 수열이 얼마나 유사한지 유사트리플 정의
# P[i] < P[j] < P[k] 이면서 Q[i] < Q[j] < Q[k]인 인덱스 (i, j, k)가 존재
# 유사도는 유사 트리플의 개수로 정의

# BIT(fenwick tree)
import sys


from sortedcontainers import SortedList


class Solution(object):
    def goodTriplets(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        pos = [0] * len(nums1)
        for k, v in enumerate(nums2):
            pos[v] = k

        pos_in_b, pre = SortedList([pos[nums1[0]]]), [0]
        for n in nums1[1:]:
            pos_in_b.add(pos[n])
            pre.append(pos_in_b.bisect_left(pos[n]))

        nums1 = nums1[::-1]
        nums2 = nums2[::-1]
        for k, v in enumerate(nums2):
            pos[v] = k
        pos_in_b, suf = SortedList([pos[nums1[0]]]), [0]
        for n in nums1[1:]:
            pos_in_b.add(pos[n])
            suf.append(pos_in_b.bisect_left(pos[n]))
        suf = suf[::-1]

        result = 0
        for x, y in zip(pre, suf):
            result += x*y
        return result


input = sys.stdin.readline
n = int(input())
arr_p = list(map(int, input().split()))
arr_q = list(map(int, input().split()))
s = Solution()
result = s.goodTriplets(arr_p, arr_q)
print(result)
