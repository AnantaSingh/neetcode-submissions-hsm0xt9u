class TimeMap:

    def __init__(self):
        # rem to use self everywhere
        self.keyStore = defaultdict(list) # this is a short to have default values for keys
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.keyStore[key].append([value, timestamp])
        

    def get(self, key: str, timestamp: int) -> str:
        values = self.keyStore[key]
        l, r = 0, len(values) - 1
        res = ""

        while l <= r:
            mid = (l+r) // 2 # this is for row finding. each has 2 cols value, time
            if values[mid][1] <= timestamp:
                res = values[mid][0] # mid i considered here
                l = mid+1
            else:
                r = mid-1
        
        return res
        

        
