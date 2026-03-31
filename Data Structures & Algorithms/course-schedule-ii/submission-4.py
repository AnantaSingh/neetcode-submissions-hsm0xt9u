class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        res = []
        prereq = {i:[] for i in range(numCourses)}
        for cr, pre in prerequisites:
            prereq[cr].append(pre)

        visit = set() #for not having one course more than once in ans
        cycle = set() # for detecting cycles

        def dfs(course):
            if course in cycle:
                return False
            if course in visit:
                return True

            cycle.add(course)
            visit.add(course)
            for pr in prereq[course]:
                if not dfs(pr):
                    return False
            
            res.append(course)
            cycle.remove(course)
            prereq[course] = []
            return True # forgot this

        for c in range(numCourses):
            if not dfs(c):
                return []
        
        return res


        