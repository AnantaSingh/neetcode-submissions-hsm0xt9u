class Solution 
{
    public int numDecodings(String s) 
    {
        int n = s.length();
        int[] dp = new int[n+1];
        // we need 2 previous so we start for loop from 2
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        System.out.println("s.charAt(0) " + s.charAt(0));
        System.out.println("Integer.valueOf(s.charAt(0)) " + Integer.valueOf(s.charAt(0)));
        // read this the based on input out changes for Integer.valueOf - char it automatically converts to int
        // https://www.geeksforgeeks.org/integer-valueof-method-in-java/
        
        
        //12
        for(int i=2; i <= s.length(); i++)
        {
            int oneDigit = Integer.valueOf(s.substring(i-1, i)); 
            int twoDigit = Integer.valueOf(s.substring(i-2, i));

            if(oneDigit >= 1 && oneDigit <=9)
                dp[i] = dp[i] + dp[i-1];

            if(twoDigit >= 10 && twoDigit <=26)
                dp[i] = dp[i] + dp[i-2];
            
        }

        return dp[n];    
    }
}
