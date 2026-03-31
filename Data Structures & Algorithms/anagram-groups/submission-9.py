class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        # in java like i was sorting the string as a key and using it

        result = defaultdict(list)
        # result = {}

        for string in strs:
            key = ''.join(sorted(string)) # new stuff sorted(string) returns characters, hence we join
            result[key].append(string) # directly we can append because we did defaultdict() so
            # map by default has a list for every item


        return result.values()
        