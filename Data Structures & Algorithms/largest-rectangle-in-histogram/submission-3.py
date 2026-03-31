class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        maxArea = 0


        for i, h in enumerate(heights):
            start = i;
            while stack and stack[-1][1] > h: #has to be while forgot
                index, height = stack.pop()
                maxArea = max(maxArea, height * (i-index))
                start = index
            stack.append([start, h])

        for i, h in stack: #has to be stack not heights here
            maxArea = max(maxArea, h * (len(heights)-i))

        return maxArea
        