class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product1, product2 = 1, 1
        output = [1] * len(nums) # declaration of array is not just []
        # WE USE Output IT IS NOT inplace

        for i in range(len(nums)):
            output[i] = product1
            product1 = product1 * nums[i]


        for i in range(len(nums)-1,-1,-1): # how to go in array in reverse
            output[i] = product2 * output[i]
            product2 = product2 * nums[i]

        return output

        



        