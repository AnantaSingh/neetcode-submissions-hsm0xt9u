class Solution {
    Map<Integer, List<Integer>> preReq = new HashMap<>();
    Set<Integer> visit = new HashSet<Integer>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < prerequisites.length; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            preReq.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }

        for(int i = 0; i < numCourses; i++)
        {
            if(dfs(i) == false)
                return false;
        }

        return true;
    }

    public boolean dfs(int course)
    {
        if(visit.contains(course))
            return false;

        visit.add(course);
        List<Integer> list = preReq.getOrDefault(course, new ArrayList<>());
        for(Integer k : list)
        {
            if(dfs(k) == false)
                return false;
        }
        visit.remove(course);
        return true;

    }
}
