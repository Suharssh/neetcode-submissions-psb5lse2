class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = k;
        int mindiff = Integer.MAX_VALUE;
        int diff = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            if(r-l+1 > k){
                diff -= nums[l];
                l++;
            }
            diff = nums[r] - nums[l];
            if(r-l+1 == k) mindiff = Math.min(diff,mindiff);
        }
        return mindiff;
    }
}