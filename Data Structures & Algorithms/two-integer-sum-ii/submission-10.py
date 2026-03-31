class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:

        l = 0
        r = len(numbers) - 1

        # O[1] space makes it diffrent from 2 sum

        while l < r:
            sum = numbers[l] + numbers[r]
            if sum > target:
                r -= 1
            elif sum < target:
                l += 1
            else:
                return [l+1, r + 1]
            
        return []

        # visit = {}

        # for i in range(len(numbers)):
            
        #     check_element = target - numbers[i]
        #     if check_element in visit:
        #         return [visit[check_element] +1, i + 1] # very diff accessing elements
            
        #     visit[numbers[i]] = i # very different adding elements like straighforward via index
        #     # no methods like add etc

        # return []

        
         
        