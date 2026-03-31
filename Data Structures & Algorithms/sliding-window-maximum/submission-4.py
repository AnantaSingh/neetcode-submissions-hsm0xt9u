class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        window = defaultdict(int)
        res = []

        for i in range(k):
            window[nums[i]] = 1 + window[nums[i]]

        res.append(max(window))

        # print(window)

        l = 0
        for r in range(k, len(nums)):
            window[nums[r]] = window[nums[r]] + 1
            # print(res)
            window[nums[l]] = window[nums[l]] - 1
            if window[nums[l]] == 0:
                del window[nums[l]]
            res.append(max(window))
            l = l + 1


        return res




        
        