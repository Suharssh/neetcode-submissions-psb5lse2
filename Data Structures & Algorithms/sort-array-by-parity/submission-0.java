class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length-1;
        for(int num : nums){
            if(num%2==0){
                res[l++] = num;
            } else {
                res[r--] = num;
            }
        }
        return res;
    }
}