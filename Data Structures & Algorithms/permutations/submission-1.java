class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(ans, curr, nums);
        return ans;   
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums)
    {
        if(curr.size() == nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int n : nums)
        {
            if(!curr.contains(n)) // we dont want any repitition
            {
                curr.add(n);
                backtrack(ans, curr, nums);
                curr.remove(curr.get(curr.size()-1));
            }
        }
    }
}
