class Solution {
    public boolean isPalindrome(String s) {

        // change to lower case
        // get the ascii code and 
        //put if its not within the the alpha numeric range ignore
        // else append the char to String
        // string reverse and compare

        //s = s.toLowerCase();
        //System.out.println(s);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < s.length(); i++)
        {
            char p = s.charAt(i);

            if((p >= 65 && p <=90)|| (p >= 97 && p <=122) || (p >= 48 && p <=57))
            {
                sb.append(p);
            }
            else
            {
                continue;
            }
        }

        String first = sb.toString();
        String second = sb.reverse().toString();

        first = first.toLowerCase();
        second = second.toLowerCase();

        return (first.equals(second));
        
    }
}
