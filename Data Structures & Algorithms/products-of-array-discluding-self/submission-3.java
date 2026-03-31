class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product1 = 1;
        int product2 = 1;
        int length = nums.length;
        int[] output = new int[length];

        for(int i=0; i < length; i++)
        {
            output[i] = product1;
            product1 = product1 * nums[i];
        }

        for(int i=length-1; i >=0; i--)
        {
            output[i] = output[i] * product2;
            product2 = product2 * nums[i];
        }

        return output; 
    }
}  
