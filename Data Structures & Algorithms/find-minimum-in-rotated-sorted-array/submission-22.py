class Solution:
    def findMin(self, nums: List[int]) -> int:
        #need to find 
        l, r = 0, len(nums) - 1
        res = nums[l]

        while l <= r:
            if nums[l] <= nums[r]:
                res = min(res, nums[l])
                break
            
            mid = (l+r) // 2
            if nums[mid] >= nums[l]:
                l = mid+1
            else:
                r = mid

        return res

        