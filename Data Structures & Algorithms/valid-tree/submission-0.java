class Solution {
    // no cycles
    // connected
    // undirected so need to keep that checked

    Set<Integer> visit = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {

        for(int i =0; i < edges.length; i ++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            map.computeIfAbsent(a, k-> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k-> new ArrayList<>()).add(a);
        }


        if(dfs(0, -1) == false)
                return false;

       return visit.size() == n; // connected

    }

    public boolean dfs(int node, int previous)
    {
        if(visit.contains(node)) // let node be x. We came from its parent here (previous)
            return false;


        visit.add(node);
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        for(Integer neighbour : list) // start checking neighbours of x
        {
            if(neighbour == previous) 
                continue;
            if(dfs(neighbour, node) == false)
                return false;
        }

        return true;

    }
}
