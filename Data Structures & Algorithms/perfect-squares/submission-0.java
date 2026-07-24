class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int cnt = 1;
        while(cnt*cnt <= n){
            int sq = cnt*cnt;
            for(int i = sq; i <= n; i++){
                dp[i] = Math.min(dp[i], dp[i-sq] + 1);
            }
            cnt++;
        }
        return dp[n];
        
    }
}