class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Group duplicates together
        
        // Start with an initial result containing a single empty list
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        // Delegate the permutation-building logic to our helper function
        return helper(nums, result);
    }

    private List<List<Integer>> helper(int[] nums, List<List<Integer>> currentResult) {
        // Iterate through each number in the array one by one
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> nextLevelPermutations = new ArrayList<>();
            
            // For every single permutation built so far...
            for (List<Integer> permute : currentResult) {
                // Try inserting the current number into every possible index slot
                for (int j = 0; j <= permute.size(); j++) {
                    List<Integer> copy = new ArrayList<>(permute);
                    copy.add(j, num);
                    nextLevelPermutations.add(copy);
                    
                    // CRUCIAL DUPLICATE CHECK: 
                    // If the element already sitting at index 'j' matches the number we just inserted,
                    // stop shifting 'j' to the right. This prevents duplicate unique arrays.
                    if (j < permute.size() && permute.get(j) == num) {
                        break; 
                    }
                }
            }
            // Move the successfully built level forward
            currentResult = nextLevelPermutations;
        }
        
        return currentResult;
    }
}