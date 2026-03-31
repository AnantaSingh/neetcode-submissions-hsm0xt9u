class Solution {

    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        for(String s : strs)
        {
            int length = s.length();
            sb.append(length).append("#").append(s);
            //System.out.println(sb);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < str.length())
        {
            int j = i;
            while(str.charAt(j) != '#')
            {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j + length + 1;
            String p = str.substring(j+1, i);
            ans.add(p);

        }

        return ans;


    }
}
