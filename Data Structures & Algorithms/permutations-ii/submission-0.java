class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {  
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> current = new ArrayList<>();
        Set<Integer> seenIndex = new HashSet<>(); 

        backtrack(nums, current, seenIndex, ans); //recursion 
        return ans; 
    }

    public void backtrack(int[] nums, List<Integer> current, Set<Integer> seenIndex, List<List<Integer>> ans) {
        if(nums.length == 0) { 
            return; 
        }

        if(current.size() == nums.length && !ans.contains(current)) { //add if we are at length and do not have dup
            ans.add(new ArrayList<>(current)); 
            return;
        }

        for(int i = 0; i < nums.length; i++) { 
            if (seenIndex.contains(i)) {
                continue;
            }

             //add index i
             current.add(nums[i]);
             seenIndex.add(i); 
             backtrack(nums, current, seenIndex, ans);

            current.remove(current.size() - 1);
            seenIndex.remove(i);
             //don't add index i
        }

    }

}