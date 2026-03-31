class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures) # updating by index
        stack = []
        # result = [] appending dynamically

        for i, n in enumerate(temperatures):
            while stack and stack[-1][1] < n: # important it is while
                index, temp = stack.pop()
                result[index] = i - index
    
            stack.append([i, n])
        
        return result




        