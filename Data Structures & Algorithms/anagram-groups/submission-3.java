class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>(); // correct

        for(String s : strs) //correct
        {
            int[] count = new int[26];
            for(char ch : s.toCharArray()) // Wrong - remember char ch declare
            {
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count); //very new will create like 1a1e2f
            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s); //No PUT required here  
        }

        return new ArrayList<>(map.values());
        
    }
}

