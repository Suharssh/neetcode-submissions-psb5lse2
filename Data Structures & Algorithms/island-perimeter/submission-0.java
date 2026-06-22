class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int p = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    p += dfs(grid, r, c);
                }
            }
        }
        return p;
    }
    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 1;
        if(grid[r][c] == -1) return 0;
        grid[r][c] = -1;
        return (dfs(grid, r+1, c) + 
                dfs(grid, r-1, c) + 
                dfs(grid, r, c+1) + 
                dfs(grid, r, c-1));   
    }
}