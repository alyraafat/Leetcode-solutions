class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        zero_idx = -1
        num_zeros = 0
        for i, num in enumerate(nums):
            if num==0:
                num_zeros+=1
                if zero_idx == -1:
                    zero_idx = i
            elif zero_idx!=-1:
                nums[zero_idx] = num
                zero_idx+=1

        for j in range(-num_zeros, 0):
            nums[j] = 0
        return nums
        
                    
                