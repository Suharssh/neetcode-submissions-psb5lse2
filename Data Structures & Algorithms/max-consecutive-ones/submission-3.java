class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        int maxcnt = 0;
        while(r<nums.length){
            if(nums[r] == 1){
                cnt++;
                maxcnt = Math.max(cnt,maxcnt);
            } else {
                l = r+1;
                cnt = 0;
            }
            r++;
        }
        return maxcnt;
    }
}