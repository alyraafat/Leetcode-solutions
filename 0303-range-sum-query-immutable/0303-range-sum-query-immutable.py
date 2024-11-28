class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums
        self.prefix_sum = [nums[0]]
        for i in range(1, len(nums)):
            num = nums[i]
            self.prefix_sum.append(self.prefix_sum[-1]+num)

    def sumRange(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: int
        """
        return self.prefix_sum[right] - self.prefix_sum[left] + self.nums[left]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)