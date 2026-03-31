class Solution {
    List<List<Integer>> ans = new ArrayList<>();
     List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return ans;   
    }

    public void backtrack(int[] nums)
    {
        if(curr.size() == nums.length)
        {
           // System.out.println(curr);
            ans.add(new ArrayList<>(curr));
            return;
        }


        
        for(int n : nums)
        {
            if(!curr.contains(n)) // we dont want any repitition
            {
                curr.add(n);
                backtrack(nums);
                // System.out.println(n + " " + curr.get(curr.size()-1));
                curr.remove(curr.size()-1);
            }
        }
    }
}
