class Solution:
    def findMin(self, nums: List[int]) -> int:
        # [3,4,5,6,1,2] -- for this one condition 2
        # [1,2,3,4,5,6] -- for this one condition 1

        l = 0
        r = len(nums)-1
        res = nums[l]

        while l <= r:
            if nums[l] <= nums[r]: #equality condition 1
                res = min(res, nums[l])
                break

            mid = (l+r) // 2
            if nums[mid] >= nums[l]: #equality condition 2
                l = mid+1
            else:
                r = mid

        return res
        


        