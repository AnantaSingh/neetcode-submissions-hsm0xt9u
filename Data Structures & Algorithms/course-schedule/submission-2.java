class Solution 
{
    Map<Integer, List<Integer>> prereq = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        // for(int i = 0; i < numCourses; i++)
        // {
        //     prereq.put(i, new ArrayList<>());
        // }

        for(int[] p : prerequisites)
        {
            prereq.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]); // cannot use getOrDefault
        }


        for(int i= 0; i < numCourses; i++) // forgto this looop
        {
            if(dfs(i) == false) // forgot this 
                return false;
        }

        return true;
                
    }

    public boolean dfs(int course)
    {
        if(visit.contains(course))
            return false;

        visit.add(course);
        List<Integer> pre = prereq.getOrDefault(course, new ArrayList<>());
        for(int n : pre)
        {
            boolean check = dfs(n);
            if(check == false) // forgot this 
                return false;
        }
        visit.remove(course);
        return true;
    }


}