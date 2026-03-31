class Solution:
    def findMin(self, nums: List[int]) -> int:
        # [3,4,5,6,1,2] -- this one condition
        # [1,2,3,4,5,6] -- this one condition

        l = 0
        r = len(nums)-1
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
        


        