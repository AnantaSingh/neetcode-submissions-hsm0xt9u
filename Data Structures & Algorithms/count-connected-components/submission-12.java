class Solution 
{
    Set<Integer> visit = new HashSet<>();
    //Set<Integer> cycle = new HashSet<>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    public int countComponents(int n, int[][] edges) 
    {
        int comp = 0;
        for(int i=0; i < edges.length; i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        for(int i=0; i < n; i++)
        {
            if(!visit.contains(i))
            {
                dfs(i);
                comp++;
            }
        }
        return comp;
    }

    public void dfs(int node)
    {
        if(visit.contains(node))
            return;
        visit.add(node);

        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());
        for(Integer e : neighbours)
        {
                dfs(e);
        }
        return;
    }
}
