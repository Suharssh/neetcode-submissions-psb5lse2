class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c <cols; c++){
                if(grid[r][c] == 0){
                    q.add(new int[] {r,c});
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] direction : directions){
                int nr = cell[0] + direction[0];
                int nc = cell[1] + direction[1];
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == Integer.MAX_VALUE){
                    grid[nr][nc] = grid[cell[0]][cell[1]] + 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
    
}
