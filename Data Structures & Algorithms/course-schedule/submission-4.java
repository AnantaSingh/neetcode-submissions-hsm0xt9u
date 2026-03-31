

class Solution {
    Map<Integer, List<Integer>> prereq = new HashMap<>();
    Set<Integer> visit = new HashSet<>(); // nodes in current recursion stack
    Set<Integer> safe  = new HashSet<>(); // nodes already proven acyclic

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Reinit per call (defensive; LeetCode usually creates a fresh Solution)
        prereq.clear();
        visit.clear();
        safe.clear();

        // Build adjacency: course -> list of prerequisites
        for (int[] p : prerequisites) {
            // to take p[0], must take p[1] first
            prereq.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        // Try DFS from every course (important!)
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int course) {
        if (safe.contains(course)) return true;    // already checked, no cycle below
        if (visit.contains(course)) return false;  // back edge -> cycle

        visit.add(course);
        List<Integer> pre = prereq.getOrDefault(course, Collections.emptyList());
        for (int n : pre) {
            if (!dfs(n)) return false;
        }
        visit.remove(course);
        safe.add(course); // memoize as acyclic
        return true;
    }
}
