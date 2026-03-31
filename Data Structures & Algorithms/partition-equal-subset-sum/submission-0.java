class Solution {
    public boolean canPartition(int[] nums) 
    {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0)
        {
            return false;
        }

        int target = sum / 2;
        Set<Integer> dpset = new HashSet<>();
        dpset.add(0); 

        for(int i=nums.length-1; i>=0; i--)
        {
            Set<Integer> nextDpset = new HashSet<Integer>();
            for(int t:dpset)
            {
                if(t+ nums[i] == target)
                {
                    return true;
                }
                nextDpset.add( t + nums[i]);
                nextDpset.add(t);
            }
            dpset = nextDpset;
        }

        return dpset.contains(target) ? true : false;
      
    }
}
