class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prereq = {}

        for i, n in enumerate(nums):
            diff = target - n
            if diff in prereq:
                return [prereq[diff], i]
            prereq[n] = i

        return []
                


        
        