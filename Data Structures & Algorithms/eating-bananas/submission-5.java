class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {

        // think of it as food/ time/ rate 
        // min rate we need
        // the rate cannot be more than the amoufoodnt (jitna h utna hi khayega)
        // take rate as max first
        // time we have max

        // then do BS from 1 to maxRate
        // if the  food/midvalue  = time then check if its <=h means we can go further low
        



        // complexity will be O(log m * n)
        int MAX = piles[0];
        
        for(int pile : piles)
        {
            MAX = Math.max(MAX, pile); // take rate as max of piles
        }

        int res = MAX; // let first assume its the largest

        // let do binary search on value of k
        // k can be between 1 to MAX

        int l = 1, r = MAX; // its consecutive numbers so these can be taken as indexes

        while(l <= r)
        {
            int mid = (l+r)/2; //rate
            
            int time = 0;
            for(int pile : piles)
            {
                time = time + (int)Math.ceil((double)pile/mid); // time
            }

            if(time <= h)
            {
                res = Math.min(res,mid);
                r = mid - 1; // we will try findind lower rate
            }
            else
            {
                l = mid + 1; 

            }

        }

        return res;

        
    }
}
