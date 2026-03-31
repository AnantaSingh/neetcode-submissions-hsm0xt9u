class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        charMap = defaultdict(int)
        left = 0
        right = 0
        maxLength = 0

        # "AAABABB"

        while right < len(s): # remember this left < right in 2 pointers but not here
            charMap[s[right]] =  charMap[s[right]] + 1
            if (right-left+1) - max(charMap.values()) > k: # VERY IMP LOGIC, if remember then can do Q
                
                charMap[s[left]] = charMap[s[left]] -1
                left = left +1

            maxLength = max(maxLength, right - left + 1)
            right += 1

        return maxLength


        
        