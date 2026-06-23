class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    q.add(new int[] {r,c});
                } else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int min = 0;
        while(!q.isEmpty() && fresh > 0){
            min++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                
                for(int[] direction : directions){
                    int nr = cell[0] + direction[0];
                    int nc = cell[1] + direction[1];
                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? min : -1;
    }
}
