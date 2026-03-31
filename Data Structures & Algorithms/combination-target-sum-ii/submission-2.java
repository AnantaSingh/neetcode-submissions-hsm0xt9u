class Solution {
    List<Integer> sublist = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;
        backtrack(0,0);
        return ans;
    }

    public void backtrack(int sum, int i)
    {
        if(sum == target)
        {
            ans.add(new ArrayList<>(sublist));
            return;
        }

        if(i == candidates.length || sum > target)
            return;

        sublist.add(candidates[i]);
        backtrack(sum + candidates[i], i+1);

        sublist.remove(sublist.size()-1);

        while(i+1 < candidates.length && candidates[i] == candidates[i+1])
            i++;

        backtrack(sum, i+1);

    }
}
