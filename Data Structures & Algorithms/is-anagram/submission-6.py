class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): # always forget this
            return False

        countT, countS = {}, {} # you do it twice in one line

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0);
            countT[t[i]] = 1 + countT.get(t[i], 0);

        return countT == countS # this is some weirdness



        