class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        characters = set()
        maxLength = 0
        left = 0
        right = 0

        while right < len(s):
            while left < right and s[right] in characters:
                characters.remove(s[left])
                left += 1
            characters.add(s[right])
            maxLength = max(maxLength, right - left + 1)
            right += 1

        return maxLength




        