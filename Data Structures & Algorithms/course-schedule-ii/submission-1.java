class Solution 
{
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> cycle = new HashSet<>(); // for cycle checking in one path
    Set<Integer> visit = new HashSet<>(); // for not adding an element more than once
    List<Integer> ans = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        for(int i=0; i < prerequisites.length; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }

        for(int i=0; i < numCourses; i++)
        {
            if(dfs(i) == false)
                return new int[0];
        }

        int[] array = new int[ans.size()];
        int c = 0;

        for(Integer k : ans)
            array[c++] = k;


        return array;
        
    }

    public boolean dfs(int course)
    {
        if(cycle.contains(course))
            return false;

        if(visit.contains(course))
            return true;

        cycle.add(course);
        List<Integer> list = map.getOrDefault(course, new ArrayList<>());
        for(Integer k : list)
        {
            if (dfs(k) == false) // 2 times flase
                return false;
        }

        cycle.remove(course);
        visit.add(course);
        ans.add(course);
        return true;


    }
}
