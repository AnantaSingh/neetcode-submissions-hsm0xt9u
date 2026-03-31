class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // make a map with key and values
        // return the values
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();


        for(String s : strs)
        {
            char[] ch = s.toCharArray();
            // String key = Arrays.sort(ch); -- WRONG
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> sl = map.getOrDefault(key, new ArrayList<>());
            //how to append to s
            sl.add(s);
            map.put(key, sl);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }

        return ans;


        
    }
}
