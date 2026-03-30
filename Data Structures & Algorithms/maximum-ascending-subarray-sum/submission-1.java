class Solution {
    public int maxAscendingSum(int[] nums) {
        int curr = nums[0];
        int maxsum = curr;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                curr+=nums[i];
            } else {
                curr = nums[i];
            }
            maxsum = Math.max(curr, maxsum);
        }
        return maxsum;
    }
}