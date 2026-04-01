
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        // concept is we take 2 int arrays for char count and matches
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        int matches = 0;

        for(int i=0; i < s1.length(); i++)
        {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i< 26 ; i++)
        {
            if(s1count[i] == s2count[i])
                matches++;
        }

        // the sliding window one are generally l = 0 and r in loop
        int l=0;

        for(int r = s1.length(); r < s2.length() ; r++) // we need to move over s2
        {
            if(matches == 26)
                return true;

            int index = s2.charAt(r) - 'a';
            s2count[index]++;
            if(s1count[index] == s2count[index])
                matches++;
            else if(s1count[index] + 1 == s2count[index])
                matches--;

            index = s2.charAt(l) - 'a';
            s2count[index]--;
            if(s1count[index] == s2count[index])
                matches++;
            else if(s1count[index] - 1 == s2count[index])
                matches--;

            l++;
        }
        return matches == 26;     
    }
}


