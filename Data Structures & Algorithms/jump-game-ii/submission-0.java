class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;

        //left finalize
        //right finalize
        //inc result

        while(right < n-1) // very imp it is less than not equal
        {
            int farthest = 0;
            for(int i = left; i <= right; i++)
            {
                farthest = Math.max(farthest, i + nums[i]);   
            }
            left = right +1;
            right = farthest;
            result++;
        }

        return result;




        
    }
}
