class Solution(object):
    def reversePrefix(self, word, ch):
        """
        :type word: str
        :type ch: str
        :rtype: str
        """
        res = ""
        found = False
        for c in word:
            if c != ch and not found:
                res = c + res
            elif c==ch and not found:
                res = c + res
                found = True
            else:
                res+=c
        if not found:
            return word
        else:
            return res
            