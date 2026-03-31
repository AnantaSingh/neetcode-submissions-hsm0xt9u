class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort() # this works not sorted(nums) why??
        n = len(nums)
        res = []

        # how to print
        # how to add in list of list

        for i, a in enumerate(nums): # use ennumerate
            if nums[i] > 0: # can never be 0
                break
            
            if i > 0 and nums[i] == nums[i-1]: # remember this is if NOT while
                continue

            l = i + 1
            r = n - 1 # remains n-1
            while l < r:
                sum = nums[i] + nums[l] + nums[r]
                if sum > 0:
                    r -= 1
                elif sum < 0:
                    l += 1
                else:
                    res.append([nums[i], nums[l], nums[r]]) # add an array of arrays
                    l += 1
                    r -= 1 # r is also decreased remember
                    while nums[l-1] == nums[l] and l < r: # l < r add 
                        l += 1
        
        return res




 

        
        