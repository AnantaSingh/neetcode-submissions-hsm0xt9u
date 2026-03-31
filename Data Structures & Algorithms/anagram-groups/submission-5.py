class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = {}

        for s in strs:
            sortedstr = ''.join(sorted(s))
            res[sortedstr] = res.get(sortedstr, [])
            res[sortedstr].append(s)

        return list(res.values())

        
        