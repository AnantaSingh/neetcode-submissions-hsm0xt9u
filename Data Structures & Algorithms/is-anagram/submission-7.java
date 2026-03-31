class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] chartoint = new int[26];

        for(int i =0; i < s.length(); i++)
        {
            chartoint[s.charAt(i) - 'a']++;
            chartoint[t.charAt(i) - 'a']--;
        }

        for(int n : chartoint)
        {
            if(n != 0)
                return false;
        }

        return true;

    }
}
