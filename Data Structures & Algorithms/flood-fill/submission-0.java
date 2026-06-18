class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int ini = image[sr][sc];
        int[][] ans = image;
        dfs(image, sr, sc, color, ini);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int ini){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if(image[sr][sc] != ini) return;
        image[sr][sc] = color;
        dfs(image,sr-1,sc,color,ini);
        dfs(image,sr+1,sc,color,ini);
        dfs(image,sr,sc-1,color,ini);
        dfs(image,sr,sc+1,color,ini);
    }
}