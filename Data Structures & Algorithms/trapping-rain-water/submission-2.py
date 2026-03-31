class Solution:
    def trap(self, height: List[int]) -> int:
        # find leftmax, right max
        # but min of those take and calculate for each i
        l, r = 0, len(height) - 1
        leftMax = height[l]
        rightMax = height[r]
        res = 0

        while l < r:
            if leftMax < rightMax:
                l += 1 # this is before anything not in the end
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]
                #l += 1 NOT HERE
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
        
        return res

        
        