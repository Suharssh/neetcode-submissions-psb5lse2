class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1, 1}, {-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        if(grid[0][0] != 0) return -1;
        else {
            q.add(new int[] {0,0});
            grid[0][0] = 1;
            while(!q.isEmpty()){
                int size = q.size();
                count++;
                for(int i = 0; i < size; i++) {
                    int[] cell = q.poll();
                    if (cell[0] == rows - 1 && cell[1] == cols - 1) {
                        return count;
                    }
                    for(int[] direction : directions){
                        int nr = cell[0] + direction[0];
                        int nc = cell[1] + direction[1];
                        if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 0){
                            q.add(new int[] {nr,nc});
                            grid[nr][nc] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
}