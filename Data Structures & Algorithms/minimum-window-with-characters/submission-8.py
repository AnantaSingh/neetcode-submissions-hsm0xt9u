class Solution:
    def minWindow(self, s: str, t: str) -> str:

        countT, window = defaultdict(int), defaultdict(int)
        
        res = [-1,-1]
        resLen = float('inf') #FORGOT

        for i in range(len(t)):
            countT[t[i]] =  countT[t[i]] + 1

        have, need = 0, len(countT)
        l = 0
        for r in range(len(s)):
            window[s[r]] = window[s[r]] + 1
            if s[r] in countT and window[s[r]] == countT[s[r]]:
                have = have + 1
            
            while have == need:
                if r - l + 1 < resLen:
                    resLen = r - l + 1
                    res = [l, r+1]

                window[s[l]] =  window[s[l]]  - 1
                if s[l] in countT and  window[s[l]] + 1 == countT[s[l]]:
                    have = have - 1
                l = l + 1

        l, r = res
        return s[l:r] if resLen is not float('inf') else ""



        
        