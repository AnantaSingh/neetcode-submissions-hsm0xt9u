class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visit = {}

        for i in range(len(nums)):
            a = nums[i]
            if (target - a) in visit:
                return [visit[(target - a)], i]
            visit[nums[i]] = i

        return []

        