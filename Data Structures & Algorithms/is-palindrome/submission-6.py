class Solution:
    def isPalindrome(self, s: str) -> bool:
        l = 0
        r = len(s)-1

        while l <=r:
            while l < r and not self.isalphaNum(s[l]): # has to be l<r not l<=r. JUST not
                l += 1
            
            while l < r and not self.isalphaNum(s[r]): # completely forgot this and self needs to be added
                r -= 1

            if s[l].lower() != s[r].lower(): # just lower
                return False
            l += 1
            r -=1

        return True

    def isalphaNum(self, c): # completely forgot ord and this

        if ord('A') <= ord(c) <= ord('Z') or ord('a') <= ord(c) <= ord('z') or ord('0') <= ord(c) <= ord('9'):
            return True
        
        return False

        


        