class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        i = 0
        j = 0
        res = ''
        while j<len(s):
            if s[j]!=' ':
                j+=1
            else:
                rev_word = s[i:j][::-1]
                res += rev_word + " "
                j+=1
                i=j
        res += s[i:j][::-1]
        return res
                
                
            
        