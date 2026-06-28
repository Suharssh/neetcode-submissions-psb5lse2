class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        // first and last row
        for(int c = 0; c < cols; c++){
            dfs(heights, 0, c, pac, heights[0][c]);
            dfs(heights, rows-1, c, atl, heights[rows-1][c]);
        }

        // first and last column
        for(int r = 0; r < rows; r++){
            dfs(heights, r, 0, pac, heights[r][0]);
            dfs(heights, r, cols-1, atl, heights[r][cols-1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prev){
        if (r < 0 || c < 0 || r == heights.length || c == heights[0].length ||
            visited[r][c] || heights[r][c] < prev) return;
        visited[r][c] = true;
        dfs(heights, r, c-1, visited, heights[r][c]);
        dfs(heights, r, c+1, visited, heights[r][c]);
        dfs(heights, r-1, c, visited, heights[r][c]);
        dfs(heights, r+1, c, visited, heights[r][c]);
    }
}
