class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        nums.sort()
        # -2,-1,1,2
        ans = []

        #not wanting duplicates is an extra thing

        for i in range(len(nums)):
            left = i+1
            right = len(nums) - 1

            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum > 0:
                    right = right - 1
                elif sum < 0:
                    left += 1
                else:
                    ans.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1

                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
        
        return ans



        