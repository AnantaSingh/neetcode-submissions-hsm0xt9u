class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str : strs)
        {
            sb = sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> answer = new ArrayList<>();
        int i=0;

        while(i < str.length())
        {
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.valueOf(str.substring(i, j));
            i = j + length +1;
            String p = str.substring(j+1, i);
            answer.add(p);
        }

        return answer;

    }
}
