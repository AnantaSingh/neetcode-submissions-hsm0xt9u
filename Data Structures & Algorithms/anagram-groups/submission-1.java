class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for(int i=0; i < strs.length; i++)
        {
            String s = strs[i];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String p = new String(charArray); 
            List<String> temp = new ArrayList();

            if(map.containsKey(p))
            {
                temp = map.get(p);
                temp.add(s);
                map.put(p, temp);
            }
            else
            {
                temp.add(s);
                map.put(p, temp);
            }
        } 

        for(List<String> s : map.values())
        {
            answer.add(s);
        }

        return answer;
        
    }

}
