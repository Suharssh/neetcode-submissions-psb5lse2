class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(s, 0, n, dp);
    }
    public int helper(String s, int i, int n, int[] dp){
        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;
        if(i == n-1) return 1;
        if(dp[i] != -1) return dp[i];

        // single digit decode
        int way = helper(s, i+1, n, dp);

        // 2 digits decoding
        if(i + 1 < n){
            int num = (s.charAt(i) - '0')*10 + (s.charAt(i+1) - '0');
            if(num <= 26){
                way += helper(s, i+2, n, dp);
            }
        }
        return dp[i] = way;
    }
}
