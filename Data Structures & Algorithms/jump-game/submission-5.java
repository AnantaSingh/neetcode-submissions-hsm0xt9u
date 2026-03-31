class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n-1;
        int index = n-2;

        while(index >= 0)
        {
            if(index + nums[index] >= goal)
            {
                goal = index;   
            }
            index--;
        }

        return goal == 0 ? true : false;
    }
}
