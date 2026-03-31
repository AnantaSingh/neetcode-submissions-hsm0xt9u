class Solution 
{
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        this.nums = nums;  
        this.target = target;
        backtrack(0,0);
        return ans;  
    }

    public void backtrack(int currSum, int i)
    {
        if(currSum == target)
        {
            ans.add(new ArrayList<>(subList));
            return;
        }
        
        if(currSum > target || i >= nums.length)
            return;

        subList.add(nums[i]);
        backtrack(currSum + nums[i], i);
        subList.remove(subList.size()-1);
        backtrack(currSum, i+1);

    }
}
