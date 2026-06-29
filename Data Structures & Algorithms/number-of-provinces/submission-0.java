class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        boolean found = false;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, n, isConnected);
                count++;
            }
        }
        return count;
    }
    void dfs(int currentCity, boolean[] visited, int n, int[][] graph){
        visited[currentCity] = true;
        for(int nextCity = 0; nextCity < n; nextCity++){
            if(!visited[nextCity] && graph[currentCity][nextCity] == 1){
                dfs(nextCity, visited, n, graph);
            }
        }
    }
}