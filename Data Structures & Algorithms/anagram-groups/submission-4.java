class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String s : strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr); // forgot this part. Remember make object of String
            List<String> su = map.getOrDefault(key, new ArrayList<String>());
            su.add(s);
            map.put(key, su);
        }


        //forgot how to traverse Map in for
        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }

        return ans;





        
    }
}
