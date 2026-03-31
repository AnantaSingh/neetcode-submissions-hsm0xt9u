class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i < nums.length; i++)
        {
            if(i > 0 && nums[i-1] == nums[i]) // here its IF
                continue; // its not i++ wont work

            int l = i+1;
            int r = nums.length-1;

            while(l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0)
                {
                    r--;
                }
                else if (sum < 0)
                {
                    l++;

                }
                else
                {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r])); // new thing
                    l++;
                    while(l < r && nums[l-1] == nums[l]) // here its while
                        l++;
                    
                }

            }
        }

        return ans;

        
    }
}
