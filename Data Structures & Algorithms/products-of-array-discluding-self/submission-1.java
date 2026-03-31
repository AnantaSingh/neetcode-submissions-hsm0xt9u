class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            int index = i;
            int product = 1;
            for(int j = 0; j < nums.length; j++)
            {
                if(index == j)
                {
                    continue;
                }
                else
                {
                    product = product * nums[j];
                }
            }

            output[index] = product;
        }
        return output;
    }
}  
