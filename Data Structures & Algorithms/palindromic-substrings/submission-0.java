class Solution {
    public int countSubstrings(String s) {
          int result_start_index = 0;
        int result_length = 0;
        int count  = 0;

        for(int i = 0; i < s.length(); i++)
        {
                // odd length
                int l = i;
                int r = i;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                {
                    if(result_length < (r-l+1))
                    {
                        result_length = r-l+1;
                        result_start_index = l;
                    }
                    count++;
                    l--;
                    r++;
                }

                //even length
                l = i;
                r = i+1;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                {
                    if(result_length < (r-l+1))
                    {
                        result_length = r-l+1;
                        result_start_index = l;
                    }
                    count++;
                    l--;
                    r++;
                }

        }

        System.out.println("Count " + count);

        return count;


        
    }
}
