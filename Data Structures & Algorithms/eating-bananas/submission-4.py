class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # move left right on k since that needs to be minimized
        # piles/k sum < h
        # no need to sort piles running on k
        l = 1
        r = max(piles) #forgot this is max(piles) not h

        print(r)

        min_k = max(piles) #forgot this is max(piles) not 0 or 1. it needs to be max

        while l <= r:
            time = 0
            rate = (l+r)//2 #speed
            print(rate)
            for bananas in piles:
                time = time + math.ceil(bananas/rate) #forgot it is ceil
            print("TIME" ,time)

            if time > h:
                l = rate+1
                print("L" ,l)
            else:
                min_k = min(min_k, rate) # forgot it is rate not ime
                r = rate-1
                print("r" ,r)

        return min_k


            


        