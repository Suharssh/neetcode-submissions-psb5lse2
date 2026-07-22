class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();
        int[] dp = new int[r];
        for(int i = 0; i < triangle.get(r - 1).size(); i++){
            dp[i] = triangle.get(r - 1).get(i);
        } 

        for(int i = r - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}