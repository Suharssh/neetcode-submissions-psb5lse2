class Solution {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for(int num : nums){
            int temp = Math.max(num + rob1, rob2); 

            // [rob1, rob2, n, n+1, n+2,.....] if we choose n, we have to choose rob1 to maximize
            //                                 or we can choose rob2 only

            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
