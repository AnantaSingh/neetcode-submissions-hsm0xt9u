class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates; 
    int target;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

        backtrack(curr, 0, 0);

        return ans;

        
    }

    public void backtrack(List<Integer> curr, int i, int sum)
    {
        if(sum == target)
        {
            System.out.println("CHEKC");
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(i == candidates.length || sum > target)
        {
            return;
        }

        curr.add(candidates[i]);
        backtrack(curr, i+1, sum + candidates[i]);
        curr.remove(curr.size()-1);

        while(i+1 < candidates.length && candidates[i] == candidates[i+1])
            i++;

      
        backtrack(curr, i+1, sum);



    }
}
