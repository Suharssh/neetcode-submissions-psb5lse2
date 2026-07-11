class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for(int i = 0; i < n; i++){
            if(i != 0) temp1[i] = nums[i];
            if(i != n-1) temp2[i] = nums[i];
        }
        return Math.max(helper(temp1), helper(temp2));

        
    }
    public int helper(int[] nums){
        int rob1 = 0;
        int rob2 = 0;
        for(int num : nums){
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
