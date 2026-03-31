class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # max occuring char in the window should not excced k
        n = len(s)
        l, r = 0, 0
        maxl = 0
        count = {}

        for r in range(n):
            count[s[r]] = 1 + count.get(s[r], 0)
            
            while (r-l+1) - max(count.values()) > k: # check window valid
                count[s[l]] -= 1
                l += 1
            
            maxl = max(maxl, r-l+1) #before updating ans check if window valid
                
        
        return maxl



        