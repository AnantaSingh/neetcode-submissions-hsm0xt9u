class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        numSet = set(nums)
        largestSeq = 0

        for n in nums:
            if n-1 in numSet:
                continue
            else:
                element = n
                currSeq = 1
                while element+1 in numSet:
                    currSeq += 1
                    element += 1
                largestSeq = max(largestSeq, currSeq)
        
        return largestSeq
                



        