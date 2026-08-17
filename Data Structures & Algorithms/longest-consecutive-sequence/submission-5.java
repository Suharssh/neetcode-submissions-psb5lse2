class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        int maxlen = 0;
        for(int i = 0; i < nums.length; i++){
            int len = 1;
            
            if(!set.contains(nums[i] - 1)){
                int start = 0;
                start = nums[i];
                while(set.contains(start + 1)){
                    start++;
                    len++;
                }
            }
            
            maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }
}
