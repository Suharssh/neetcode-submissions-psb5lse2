class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int maxlen = 0;
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            int len = 1;
            if(!set.contains(nums[i] - 1)){
                start = nums[i];
                while(set.contains(start + 1)){
                    start++;
                    len++;
                } 
                maxlen = Math.max(maxlen, len);
                len = 1;
            }
        }
        return maxlen;
    }
}
