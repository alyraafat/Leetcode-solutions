class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        sum_sofar = 0
        min_len = float('inf')
        j = 0
        i=0
        while i<len(nums) or j<i:
            # print(i,j, sum_sofar)
            if sum_sofar<target and i<len(nums):
                sum_sofar += nums[i]
                i+=1
            else:
                if sum_sofar>=target:
                    min_len = min(min_len, i-j)
                    sum_sofar -= nums[j]
                j+=1
                
        if min_len == float('inf'):
            return 0
        elif sum_sofar >= target:
            min_len = min(min_len, i-j)
        return min_len