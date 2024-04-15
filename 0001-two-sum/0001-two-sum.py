class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def key(x):
            return x[1]
        coll = []
        for i, num in enumerate(nums):
            coll.append((i,num))
        coll.sort(key=key)
        i = 0
        j = len(coll)-1
        while i<j:
            if coll[i][1] + coll[j][1]>target:
                j -= 1
            elif coll[i][1] + coll[j][1]<target:
                i += 1
            else:
                return [coll[i][0], coll[j][0]]