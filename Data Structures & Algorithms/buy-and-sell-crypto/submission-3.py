class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_in_future = float("-inf")
        res = 0

        for i in prices[::-1]:
            if max_in_future > i:
                res = max(res, max_in_future - i)

            else:
                max_in_future = i

        return res

        