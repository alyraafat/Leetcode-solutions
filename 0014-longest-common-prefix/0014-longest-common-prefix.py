class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        min_len = float('inf')
        for s in strs:
            min_len = min(len(s),min_len)
        ans = ''
        for i in range(min_len):
            char = strs[0][i]
            for j in range(1, len(strs)):
                if char != strs[j][i]:
                    return ans
            ans += char
            
        return ans
        