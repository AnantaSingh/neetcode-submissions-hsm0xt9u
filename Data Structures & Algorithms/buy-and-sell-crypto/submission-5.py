class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i = 0
        j = i+1
        maxProfit = 0

        while j < len(prices):
            maxProfit = max(maxProfit, prices[j] - prices[i])
            if prices[i] > prices[j]:
                i = j
            j += 1
        
        return maxProfit
            
            


        