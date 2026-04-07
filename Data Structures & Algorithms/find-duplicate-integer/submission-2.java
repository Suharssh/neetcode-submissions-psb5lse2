class Solution {
    public int findDuplicate(int[] nums) {

        // brute force o(n) time and space
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int cnt = 0;
        // for(int i = 0; i < nums.length; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        //     if(map.get(nums[i]) > 1) cnt = nums[i];
        // } 
        // return cnt;

        // o(1) space soln - 
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
