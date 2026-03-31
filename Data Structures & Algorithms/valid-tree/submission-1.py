class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        # no cycles
        # number of visited should be equal to n. connected

        prereq = {i:[] for i in range(n)}
        for a, b in edges:
            prereq[a].append(b);
            prereq[b].append(a);

        visited = set() 

        def dfs(node, previous):
            if node in visited:
                return False

            visited.add(node)
            for nde in prereq[node]:
                if nde == previous:
                    continue
                if not dfs(nde, node):
                    return False
            return True
            
        return dfs(0, -1) and len(visited) == n



        