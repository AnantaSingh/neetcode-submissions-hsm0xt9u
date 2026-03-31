class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) < 1:
            return 0

        prefixSum = nums[0]
        largestSum = nums[0]

        for i in range(1, len(nums)):
            if prefixSum < 0:
                prefixSum = 0
            prefixSum = prefixSum + nums[i]
            largestSum = max(largestSum, prefixSum)

        return largestSum

        