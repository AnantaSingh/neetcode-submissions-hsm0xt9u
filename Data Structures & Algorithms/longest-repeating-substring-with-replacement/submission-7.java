class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int l=0;
        int res =0;

        for(int r=0; r < s.length();r++)
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);

            while(((r-l+1) - Collections.max(map.values())) > k)
            {
                int d = map.get(s.charAt(l));
                map.put(s.charAt(l), d-1);
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
        
    }
}

