class Solution {
    public int reverse(int x) 
    {
        // normal reverse x first
        // now first check the 2 limits they are Integer.MAX and MIN
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        int res = 0;

        while(x != 0)
        {
            int mod = x % 10;
            

            if(res > MAX/10 || (res == MAX/10 && mod > MAX%10))
                return 0;
            
            if(res < MIN/10 || (res == MIN/10 && mod < MIN%10))
                 return 0;

            res = res * 10 + mod;
            x = x/10;
        }

        return res;

        
        
    }
}
