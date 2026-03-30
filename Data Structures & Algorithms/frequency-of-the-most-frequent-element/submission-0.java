class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int maxfreq = 0;
        int sum = 0;
        while(r < nums.length){
            sum+=nums[r];
            while(nums[r] * (r-l+1) > sum + k){
                sum-=nums[l];
                l++;
            }
            maxfreq = Math.max(r-l+1, maxfreq);
            r++;
        }
        return maxfreq;
    }
}