class Solution {
    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k; // with k we compare p
        int l = 0;
        int r = nums.length-1;

        while(l < r)
        {
            int p = quickSelect(nums, l, r);
            if(p < k)
                l = p+1;
            else if(p > k)
                r = p-1;
            else
                break;
        }

        return nums[k]; // because p is initialized within while
        
    }

    // will return the correct partition p 
    //uske right all grater
    // uske left mei all small
    // but will also make sure the correct value is there at partition p
    public int quickSelect(int[] nums, int l, int r)
    {
        // take values on left and right
        int p = l;
        int pivot = nums[r]; // only for comparing

        for(int i = l; i < r; i++)
        {
            if(nums[i] <= pivot)
            {
                // modifying array
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }

        // now we need to modify array
        nums[r] = nums[p];
        nums[p] = pivot;

        return p;
    }


}
