class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)

        for i, t in enumerate(temperatures):
            while stack and t > stack[-1][1]:
                res = stack.pop()
                #print(res)
                result[res[0]] = i - res[0]

            stack.append((i, t))


        return result            


        