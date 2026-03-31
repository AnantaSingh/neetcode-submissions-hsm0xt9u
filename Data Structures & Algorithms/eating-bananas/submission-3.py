class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # move left right on k since that needs to be minimized
        # piles/k sum < h
        # no need to sort piles running on k
        l = 1
        r = max(piles)

        print(r)

        min_k = max(piles)

        while l <= r:
            time = 0
            rate = (l+r)//2 #speed
            print(rate)
            for bananas in piles:
                time = time + math.ceil(bananas/rate)
            print("TIME" ,time)

            if time > h:
                l = rate+1
                print("L" ,l)
            else:
                min_k = min(min_k, rate)
                r = rate-1
                print("r" ,r)

        return min_k


            


        