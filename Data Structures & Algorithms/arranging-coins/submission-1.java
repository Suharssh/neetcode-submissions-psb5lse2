class Solution {
    public int arrangeCoins(int n) {
        long l = 1;
        long h = n;
        long res = 0;
        while(l <= h){
            long m = (h+l)/2;
            long coins = m*(m+1)/2;
            if(coins > n) h = m - 1;
            else{
                l = m + 1;
                res = Math.max(res, m);
            }
        }
        return (int)res;
    }
}