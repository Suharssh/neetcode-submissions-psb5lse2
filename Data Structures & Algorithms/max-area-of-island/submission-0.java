class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxarea = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    maxarea = Math.max(maxarea, bfs(grid, r, c, rows, cols));
                }
            }
        }
        return maxarea;
    }
    private int bfs(int[][] grid, int r, int c, int rows, int cols){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        grid[r][c] = 0;
        int area = 1;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] direction : directions){
                int nr = cell[0] + direction[0];
                int nc = cell[1] + direction[1];
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1){
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }
        return area;
    }
}
