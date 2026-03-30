class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1;
        int l = 0, r = 1;
        int len = 1;
        while(r < nums.length){
            if(nums[r] > nums[l]){
                inc++;
                dec = 1;
                // len = Math.max()
            } else if(nums[r] < nums[l]) {
                dec++;
                inc = 1;
            } 
            
            else {
                inc = 1;
                dec = 1;
            }
            len = Math.max(len, Math.max(inc,dec));
            l++;
            r++;
        }
        return len;
    }
}