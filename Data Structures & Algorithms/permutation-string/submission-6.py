class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        counts1 = defaultdict(int)
        for ch in s1:
            counts1[ch] = counts1[ch] + 1
        
        print(counts1)
        counts2 = defaultdict(int)
        left = 0
        right = 0

        while right < len(s2):
            if counts1 == counts2:
                return True
            if right - left + 1 > len(s1):
                counts2[s2[left]] = counts2[s2[left]] - 1
                if counts2[s2[left]] == 0:
                    del counts2[s2[left]]
                left = left + 1
            
            counts2[s2[right]] = counts2[s2[right]] + 1
            right = right +1

        print(counts2)
        return counts1 == counts2



        
        