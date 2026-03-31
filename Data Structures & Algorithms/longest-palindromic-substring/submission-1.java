class Solution {
    public String longestPalindrome(String s) {

        int result_start_index = 0;
        int result_length = 0;

        for(int i = 0; i < s.length(); i++)
        {

                int l = i;
                int r = i;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                {
                    if(result_length < (r-l+1))
                    {
                        result_length = r-l+1;
                        result_start_index = l;
                    }
                    l--;
                    r++;
                }

                 l = i;
                 r = i+1;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                {
                    if(result_length < (r-l+1))
                    {
                        result_length = r-l+1;
                        result_start_index = l;
                    }
                    l--;
                    r++;
                }


        }

        return s.substring(result_start_index, result_start_index + result_length);


        
    }
}
