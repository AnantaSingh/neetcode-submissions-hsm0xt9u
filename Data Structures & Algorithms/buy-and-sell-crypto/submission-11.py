class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i = 0
        profit = 0

        for j in range(1,len(prices)):
            profit = max(profit, prices[j] - prices[i])
            if prices[i] > prices[j]:
                i = j
        
        return profit


        
        
        


        
        
        