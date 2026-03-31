class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:

        #find the smallest of the sequence

        visit = set(nums)
        maxSeq = 0

        for n in nums:
            if n-1 in visit: # not the start of sequence
                continue # forgot this
            else:
                currSeq = 1
                x = n
                while x+1 in visit: # forgot that this is addition
                    currSeq += 1
                    x +=1 # forgot that this is addition
                maxSeq = max(maxSeq, currSeq)

        return maxSeq

        
        