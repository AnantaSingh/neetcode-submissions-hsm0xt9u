class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        // complexity will be O(log m * n)
        int MAX = piles[0];
        
        for(int pile : piles)
        {
            MAX = Math.max(MAX, pile);
        }

        int res = MAX; // let first assume its the largest

        // let do binary search on value of k
        // k can be between 1 to MAX

        int l = 1, r = MAX; // its consecutive numbers so these can be taken as indexes

        while(l <= r)
        {
            int mid = (l+r)/2;
            int sum = 0;

            for(int pile : piles)
            {
                sum = sum + (int)Math.ceil((double)pile/mid);
            }

           // System.out.println(sum);

            if(sum <= h)
            {
                System.out.println(sum);
                res = Math.min(res,mid);
                r = mid - 1; // we will try findind lower 
            }
            else
            {
                l = mid + 1;

            }

        }

        return res;

        
    }
}
