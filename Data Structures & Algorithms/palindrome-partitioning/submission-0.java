class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> sublist = new ArrayList<>();
    public List<List<String>> partition(String s) {

        backtrack(s, 0);
        return ans;
    }

    public void backtrack(String s, int i)
    {
        if(i == s.length())
        {
            ans.add(new ArrayList<>(sublist));
            return;
        }
            

        for(int j = i; j < s.length(); j++)
        {
            if(isPalindrome(s, i, j))
            {
                sublist.add(s.substring(i, j+1));
                backtrack(s, j+1);
                sublist.remove(sublist.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
