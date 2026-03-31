class Solution {

    Map<Character, String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        if(digits.length() != 0)
            backtrack(digits, "", 0);
        return ans;
    }

    public void backtrack(String digits, String curr, int i)
    {
        if(digits.length() == curr.length())
        {
            ans.add(curr);
            return;
        }


        for(Character ch : (map.get(digits.charAt(i))).toCharArray())
        {
            //curr.append(ch); dont append so no remove required// pehle bas yeh socho d aana chahiye
            backtrack(digits, curr + ch, i+1); 
        }

    }

 
}
