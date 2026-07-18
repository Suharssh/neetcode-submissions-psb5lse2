class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 0; i < amount+1; i++){
            for(int c : coins){
                if((i-c) >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i-c]);
                }
            }
        }
        return dp[amount] != 1 + amount ? dp[amount] : -1;
    }
}