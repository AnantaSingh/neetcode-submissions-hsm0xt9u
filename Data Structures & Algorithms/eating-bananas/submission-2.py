class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        res = max(piles)
        l, r = 1, res # remember l = 1 not 0 because its rate actually
        while l <= r:
            mid = (l+r)//2
            sum = 0
            for p in piles:
                sum += math.ceil(float(p)/mid)
            if sum <= h:
                res = mid
                r = mid-1
            else:
                l = mid+1
        return res
        

        

        