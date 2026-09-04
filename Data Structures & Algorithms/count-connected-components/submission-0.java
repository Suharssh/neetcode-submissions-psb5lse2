class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                bfs(adj, vis, i);
                components++;
            }
        }
        return components;
    }
    public void bfs(List<List<Integer>> adj, boolean[] vis, int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei : adj.get(curr)){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
}
