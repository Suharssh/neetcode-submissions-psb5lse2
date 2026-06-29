class Solution {
    private final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> que = new LinkedList<>();
        boolean found = false;
        // Step 1: Find the first island and push ALL of its land cells into the queue
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfsCollectIsland(grid, i, j, visited, que, n);
                    found = true;
                    break;
                }
            }
        }   
        int bridgeLength = 0;
        // Step 2: Level-by-Level BFS to expand outward simultaneously from the whole island
        while(!que.isEmpty()){
            int size = que.size(); // Freeze the current expansion wavefront boundary 
            for(int i = 0; i < size; i++) {
                int[] node = que.poll();
                int r = node[0], c = node[1];
                for(int[] dir : directions){
                    int newR = r + dir[0], newC = c + dir[1];
                    if(newR >= 0 && newR < n && newC >= 0 && newC < n && !visited[newR][newC]){
                        if(grid[newR][newC] == 1){
                            // The wave crashed into a land cell that doesn't belong to Island 1!
                            return bridgeLength; 
                        }
                        if(grid[newR][newC] == 0){
                            visited[newR][newC] = true;
                            que.offer(new int[]{newR, newC});
                        }
                    }
                }
            }
            bridgeLength++; // Increment bridge distance after processing the entire layer
        }
        return 0;
    }
    // Pure DFS: Exclusively focuses on identifying and gathering Land cells (1s)
    private void dfsCollectIsland(int[][] grid, int i, int j, boolean[][] visited, Queue<int[]> que, int n){
        visited[i][j] = true;
        que.offer(new int[]{i, j}); // Put this land cell directly onto the starting wavefront
        for(int[] dir : directions){
            int newR = i + dir[0], newC = j + dir[1];
            if(newR >= 0 && newR < n && newC >= 0 && newC < n && !visited[newR][newC]){
                // Only follow the land link
                if(grid[newR][newC] == 1) {
                    dfsCollectIsland(grid, newR, newC, visited, que, n);
                }
            }
        }
    }
}