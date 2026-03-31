class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right: # equality
            mid = (left + right)//2 # see division
            if nums[mid] > target:
                right = mid - 1 # not including mid
            elif nums[mid] < target:
                left = mid + 1 # not including mid
            else:
                return mid

        
        return -1
        