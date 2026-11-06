class Solution {
    public int swimInWater(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == n-1 && c == n-1) return cost;

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !visit[nr][nc]){
                    visit[nr][nc] = true;
                    pq.offer(new int[]{
                        Math.max(cost, grid[nr][nc]), nr, nc
                    });
                }
            }
        }
        return n*n;
    }
}
