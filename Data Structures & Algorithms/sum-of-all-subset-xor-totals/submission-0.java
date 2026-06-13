class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public int helper(int[] nums, int idx, int currXor){
        if(idx == nums.length) return currXor;
        int withelement = helper(nums, idx+1, currXor^nums[idx]);
        int withoutelement = helper(nums, idx+1, currXor);
        return withelement + withoutelement;
    }
}