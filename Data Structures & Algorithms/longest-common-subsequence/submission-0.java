class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        // if same move diagonally
        // else max of down and bottom
        int ROWS = text1.length();
        int COLS = text2.length();

        int[][] dp = new int[ROWS+1][COLS+1];

        for(int i= ROWS-1; i >= 0; i--)
        {
            for (int j = COLS-1; j>= 0; j--)
            {
                if(text1.charAt(i) == text2.charAt(j))
                {
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];    
    }
}
