/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node, Node> map = new HashMap<>();

    
    public Node cloneGraph(Node node) {

        if(node == null)
            return null;

        return dfs(node, map);

    }


    public Node dfs(Node node, Map<Node, Node> map)
    {
        

        if(map.containsKey(node)) // remember containsKey
        {
            return map.get(node);
        }

        Node clone = new Node();
        clone.val = node.val;
        map.put(node, clone);

        for(Node np : node.neighbors)
        {
            clone.neighbors.add(dfs(np, map));
        }

        return clone; 

    }
}