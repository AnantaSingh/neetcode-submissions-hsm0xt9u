class Solution:
    def minWindow(self, s: str, t: str) -> str:
        countT, window = {}, {}

        for i in range(len(t)):
            countT[t[i]] = 1 + countT.get(t[i], 0)
        
        have, need = 0, len(countT)
        l = 0
        res = [-1,-1]
        resLen = float('inf')
        #print(resLen)

        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)

            if c in countT and window[c] == countT[c]:
                have += 1

            while have == need:
                if r - l + 1 < resLen:
                    res = [l, r+1]
                    resLen = r - l + 1
                ch = s[l]
                window[ch] -= 1

                if ch in countT and window[ch] == countT[ch] - 1:
                    have -= 1
                l += 1
        

        l, r = res
        return s[l:r] if resLen != float('inf') else ""
        



        
        