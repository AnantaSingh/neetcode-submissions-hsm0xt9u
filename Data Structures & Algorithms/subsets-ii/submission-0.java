class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, ans, curr, 0);
        return ans;

        
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr, int i)
    {
        if(i >= nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, ans, curr, i+1);
        curr.remove(Integer.valueOf(nums[i]));

        while(i+1 < nums.length && nums[i] == nums[i+1])
            i++;

        backtrack(nums, ans, curr, i+1);



    }
}
