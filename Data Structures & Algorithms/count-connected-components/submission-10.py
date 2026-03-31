class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:

        prereq = {i:[] for i in range(n)}
        for a, b in edges:
            prereq[a].append(b)
            prereq[b].append(a)

        visit = set()
        count = 0

        def dfs(course):
            if course in visit:
                return
            visit.add(course)
            for cr in prereq[course]:
                #if cr not in visit:
                dfs(cr)
            return

        for i in range(n):
            if i not in visit:
                dfs(i)
                count += 1

        return count
        