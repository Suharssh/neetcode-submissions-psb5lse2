class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        } 
        for(int i = 0; i < map.size(); i++){
            if(map.get(nums[i]) > 1) cnt = nums[i];
        }
        return cnt;
    }
}
