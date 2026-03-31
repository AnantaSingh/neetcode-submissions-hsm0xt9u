class Solution {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {


        dfs(nums, 0);
        return res; 
    }

    public void dfs(int[] nums, int i)
    {
        if(i >= nums.length)
        {
            res.add(new ArrayList<>(subset));// this is important to make a copy of subset
            return; 
        }

        subset.add(nums[i]);
        dfs(nums, i+1);
        subset.remove(subset.size()-1);
        dfs(nums, i+1);

    }
}
