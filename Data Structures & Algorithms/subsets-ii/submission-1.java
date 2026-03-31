class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {


        Arrays.sort(nums);
        backtrack(nums, 0);
        return ans;

        
    }

    public void backtrack(int[] nums, int i)
    {
        if(i >= nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, i+1);
        curr.remove(curr.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1])
            i++;

        backtrack(nums, i+1);
    }
}
