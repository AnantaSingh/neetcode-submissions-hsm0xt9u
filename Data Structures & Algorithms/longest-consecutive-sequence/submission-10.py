class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        visit = set()
        if len(nums) == 0:
            return 0
        maxSeq = 1

        for n in nums:
            visit.add(n)

        for n in nums:
            if n-1 in visit:
                x = n-1
                currSeq = 1
                while x in visit:
                    currSeq += 1
                    x -= 1
                maxSeq = max(maxSeq, currSeq)

        return maxSeq


        