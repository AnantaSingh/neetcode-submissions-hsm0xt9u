class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        visit = set()
        l, maxl = 0, 0

        for r in range(len(s)):
            while s[r] in visit:
                visit.remove(s[l])
                l += 1
            
            visit.add(s[r])
            maxl = max(maxl, r-l+1)

        return maxl





        