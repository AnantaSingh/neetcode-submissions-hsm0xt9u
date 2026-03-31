class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        # prereq 
        prereq = {i:[] for i in range(numCourses)}
        
        for crse, pre in prerequisites:
            prereq[crse].append(pre)

        visit = set();

        
        def complete(course):
            if course in visit:
                return False
            
            if prereq[course] == []:
                return True

            visit.add(course)
            for c in prereq[course]:
                if not complete(c):
                    return False
            
            visit.remove(course)
            prereq[course] = []
            return True;

        
        for c in range(numCourses):
            if not complete(c):
                return False

        return True


        

        