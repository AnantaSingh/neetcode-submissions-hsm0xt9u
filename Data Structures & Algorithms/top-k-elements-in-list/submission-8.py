class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        # if heap has a pair stored which one gets considered?
        count = {}
        for n in nums:
            count[n] = 1 + count.get(n, 0)

        heap = [] # list is converted to heap using heapify()
        for num in count.keys():
            heapq.heappush(heap, (count[num], num))
            if len(heap) > k: #always do a len for everything no size and all
                heapq.heappop(heap)

        ans = []
        for i in range(k):
            ans.append(heapq.heappop(heap)[1])

        return ans


    
 

        
        
        