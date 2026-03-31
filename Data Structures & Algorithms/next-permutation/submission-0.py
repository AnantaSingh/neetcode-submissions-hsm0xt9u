class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)

        # find pivot at i
        i = n - 2
        while i >= 0 and nums[i] >= nums[i+1]:
            i -= 1 
                
        if i < 0:
            nums.reverse()
            return
            
            # i has the pivot
            # find the number from right smallest that is greater than nums[i]
            # smallest number greater than i
        j = n - 1
        while nums[j] <= nums[i]:
            j -= 1
                
        nums[i], nums[j] = nums[j], nums[i]
            
        l = i + 1
        r = n - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
            
                
            
        