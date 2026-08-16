class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // add all the elements in the set 

        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int maxlen = 0; // incase of an empty array 
        for(int i = 0; i < nums.length; i++){
            // maintain a curr variable, check if it is the start of the sequence by checking if there is a prev number 
            int start = nums[i];
            int len = 1;
            if(!set.contains(nums[i] - 1)){
                start = nums[i];
                while(set.contains(start + 1)){
                    // if the set does not have the previous number, then check for the consecutive series, if it exists, keep increasing the len by 1 and store the maxlen throughout the array in a similar fashion.
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
