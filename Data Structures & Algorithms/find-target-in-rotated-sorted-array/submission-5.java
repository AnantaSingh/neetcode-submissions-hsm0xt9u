class Solution 
{
    public int search(int[] nums, int target) 
    {
        int left=0;
        int right= nums.length-1;
        // 4 things left, right , mid , target

        while(left <= right)
        {
            int mid = (left+right)/2;
            if(nums[mid] == target)
            {
                return mid;
            }

            //left sorted
            if(nums[mid] >= nums[left])
            {
                if(nums[mid] < target || target < nums[left]) // if target does not ∈ [left, mid) → go right
                {
                    left = mid + 1; 
                }
                else
                {
                    right = mid - 1; // if target ∈ [left, mid) → go left
                }

            }
            else //right sorted
            {
                if(nums[mid] > target || target > nums[right]) // if target does not ∈ (mid, right] → go left
                {
                    right = mid -1;
                }
                else
                {
                    left = mid + 1; // if target ∈ (mid, right] → go right
                }

            }
        }

        return -1;



        
    }
}
