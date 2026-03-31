class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visit = {}

        for i in range(len(nums)):
            
            check_element = target - nums[i]
            if check_element in visit:
                return [visit[check_element], i] # very diff accessing elements
            
            visit[nums[i]] = i # very different adding elements like straighforward via index
            # no methods like add etc

        return []

        