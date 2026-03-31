class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        prereq = {}

        for i, n in enumerate(numbers):
            diff = target - n
            if diff in prereq:
                return [prereq[diff]+1, i+1]
            prereq[n] = i

        return []
        