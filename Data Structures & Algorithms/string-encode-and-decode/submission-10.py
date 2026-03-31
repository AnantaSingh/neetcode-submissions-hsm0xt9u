class Solution:
    def encode(self, strs: List[str]) -> str:

        result = ""
        for s in strs:
            result = result + str(len(s)) + "#" + s

        print(result)
        return result
        

    def decode(self, s: str) -> List[str]:

        result = []
        i = 0
        j = 0

        while( j < len(s)):
     
            while(s[j] != "#"):
                j = j + 1

            length = int(s[i:j])
            i = j + 1 #j is #
            j = j + 1 + length
            string = s[i: j]
            print(string)
            result.append(string)
            i = j



        return result


