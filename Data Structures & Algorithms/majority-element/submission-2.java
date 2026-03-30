class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // return nums[nums.length/2];


        //HashMap approach 
        
        // int res = 0;
        // int majority = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < nums.length; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        //     if(map.get(nums[i]) > majority){
        //         res = nums[i];
        //         majority = map.get(nums[i]);
        //     }
        // }
        // return res;

        // optimal approach

        int res = 0;
        int count = 0;
        for(int n : nums){
            if(count==0) res = n;
            if(n == res){
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}