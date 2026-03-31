class Solution {
    public boolean isAnagram(String s, String t) {

        int[] chartoint = new int[26];

        // for(Character c : s) // i did this and its wrong
        // {
        //     chartoint[c - 'a']++;
        // }

        for(int i =0; i < s.length(); i++)
        {
            chartoint[s.charAt(i) - 'a']++;
        }

        for(int i =0; i < t.length(); i++)
        {
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
