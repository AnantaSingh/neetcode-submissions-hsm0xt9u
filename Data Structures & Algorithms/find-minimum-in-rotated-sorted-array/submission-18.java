class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length- 1;


        while(left <= right)
        {
            if(nums[left] <= nums[right]) // when only one element
                return nums[left];

            int mid = (left+right)/2;

            if(nums[mid] >= nums[left]) // equal is important
            {
                left = mid +1;
            }
            else
            {
                right = mid;
            }
        }

        return 0;
        
    }
}
