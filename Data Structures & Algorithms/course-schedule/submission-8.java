

class Solution {
    Map<Integer, List<Integer>> prereq = new HashMap<>();
    Set<Integer> cycle = new HashSet<>(); // nodes in current recursion stack
    Set<Integer> safe  = new HashSet<>(); // nodes already proven acyclic

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Reinit per call (defensive; LeetCode usually creates a fresh Solution)
     

        // Build adjacency: course -> list of prerequisites
        for (int[] p : prerequisites) {
            // to take p[0], must take p[1] first
            prereq.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        // Try DFS from every course (important!)
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) 
                return false;
        }
        return true;
    }

    private boolean dfs(int course) {
        if (safe.contains(course)) return true;    // already checked, no cycle below
        if (cycle.contains(course)) return false;  // back edge -> cycle

        cycle.add(course);
        for (int n : prereq.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(n)) return false;
        }
        cycle.remove(course);
        safe.add(course); // memoize as acyclic
        return true;
    }
}
