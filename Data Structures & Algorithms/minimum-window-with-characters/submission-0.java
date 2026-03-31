class Solution {
    public String minWindow(String s, String t) {

        if(t.isEmpty())
            return "";

        // maintain 2 hashmap
        Map<Character, Integer> tcount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i=0; i < t.length(); i++)
        {
            // this hashMap will not change
            char c =  t.charAt(i);    
            tcount.put(c, tcount.getOrDefault(c, 0) + 1);
        }

        // have 2 counters for have and need
        int have = 0;
        int need = tcount.size();

        // to store res
        int[] res = {-1, -1}; // NEW WAY TO STORE
        int resLen = Integer.MAX_VALUE; // ALWAYS FORGET

        // for 2 pointers l and r
        int l = 0;

        for(int r = 0; r < s.length(); r++)
        {
            // add the char to hashmap
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // now a char has come so need to increase have if needed
            // increaing have
            if(tcount.containsKey(c) && window.get(c) == tcount.get(c))
            {
                have++;
            }

            while(have == need)
            {
                // see if we need to update answer
                if((r - l + 1) < resLen)
                {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }

                //now removing the left char so first store it
                char leftchar = s.charAt(l);
                window.put(leftchar, window.get(leftchar) - 1);
                // decreasing have similar to above increasing
                if(tcount.containsKey(leftchar) && window.get(leftchar) < tcount.get(leftchar))
                {
                    have--;
                }
                l++;
            }
        }



        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
        
    }
}
