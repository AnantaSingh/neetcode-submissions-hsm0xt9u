class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        // no of edges == number of nodes -- Graph Theory
        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }


        //find union and if parent of 2 edge points come same meaning there is already a path


        for(int[] edge : edges)
        {
            if(!union(edge[0], edge[1], rank, parent))
            {
                return new int[]{edge[0], edge[1]};
            }
        }



        return new int[0];



        
    }

    public boolean union(int a, int b, int[] rank, int[] parent)
    {
        int p1 = find(a, parent);
        int p2 = find(b, parent);

        if(p1 == p2)
            return false;

        // modify parents and ranks

        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
            rank[p1] = rank[p1] +rank[p2];
        }
        else
        {
            parent[p1] = p2;
            rank[p2] = rank[p2] +rank[p1];
        }

        return true;

    }

    public int find(int node, int[] parent)
    {

        if(node != parent[node])
        {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }

}
