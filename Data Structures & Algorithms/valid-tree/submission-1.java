class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> vis = new HashSet<>();
        if(!dfs(-1, 0, vis, adj)) return false;
        return vis.size() == n;
    }
    public boolean dfs(int parent, int node, Set<Integer> vis, List<List<Integer>> adj){
        if(vis.contains(node)) return false;
        vis.add(node);
        for(int nei : adj.get(node)){
            if(nei == parent) continue;
            if(!dfs(node, nei,vis,adj)) return false;
        }
        return true;
    }
}
