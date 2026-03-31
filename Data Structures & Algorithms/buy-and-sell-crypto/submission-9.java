class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int i = 0; /// buy day
        int j = i+1; // sell day

        while(j < prices.length)
        {
            // compute profit and keep increasing buy day
            maxProfit = Math.max(maxProfit, prices[j] - prices[i]);

            // --- only below condition special
            if(prices[j] < prices[i]) // if buy day price is > sell day
            {
                i = j; // buy on that day 
            }
            j++;
        }

        return maxProfit;

        
        
    }
}
