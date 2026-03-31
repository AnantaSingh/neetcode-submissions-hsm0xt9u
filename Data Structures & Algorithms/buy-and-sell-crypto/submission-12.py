class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        profit = 0

        for j in range(1,len(prices)):
            profit = max(profit, prices[j] - buy)
            if buy > prices[j]:
                buy = prices[j]
        
        return profit


        
        
        


        
        
        