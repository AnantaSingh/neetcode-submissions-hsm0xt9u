class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        #matches
        if len(s1) > len(s2):
            return False
        
       # count1, count2 = {}, {} no maps here array
        s1count, s2count = [0] * 26, [0] * 26

        for i in range(len(s1)):
            s1count[ord(s1[i]) - ord('a')] += 1
            s2count[ord(s2[i]) - ord('a')] += 1

        matches = 0
        for i in range(26):
            matches += 1 if s1count[i] == s2count[i] else 0

        l = 0
        for r in range(len(s1), len(s2)):
            if matches == 26:
                return True
            c = s2[r]
            index = ord(c) - ord('a')
            s2count[index] += 1
            if(s2count[index] == s1count[index]):
                matches += 1
            elif (s2count[index] == s1count[index] + 1):
                matches -=1
            
            c = s2[l]
            index = ord(c) - ord('a')
            s2count[index] -= 1
            if(s2count[index] == s1count[index]):
                matches += 1
            elif (s2count[index] == s1count[index] - 1):
                matches -=1
            l += 1 # remember end
            
        return matches == 26




        