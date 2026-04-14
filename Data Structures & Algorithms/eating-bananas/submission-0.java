class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int pile : piles){
            r = Math.max(r,pile);
        }
        int ans = r;
        while(l <= r){
            int m = l + (r-l)/2;

            long hrs = 0;

            for(int pile : piles) hrs += (pile + m - 1)/ m;
            if(hrs <= h){
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
