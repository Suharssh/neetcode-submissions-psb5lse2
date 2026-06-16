class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Step 1: Build the frequency map of numbers
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Kick off the helper backtracking function
        helper(nums.length, countMap, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int targetSize, Map<Integer, Integer> countMap, 
                        List<Integer> curr, List<List<Integer>> res) {
        // Base Case: If our current arrangement matches the input size, we are done
        if (curr.size() == targetSize) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        // Iterate only through UNIQUE numbers available in the map keys
        for (int num : countMap.keySet()) {
            int count = countMap.get(num);
            
            // If we have copies of this number left to use
            if (count > 0) {
                // 1. Make the choice
                curr.add(num);
                countMap.put(num, count - 1);
                
                // 2. Explore deeper paths
                helper(targetSize, countMap, curr, res);
                
                // 3. Backtrack (Undo the choice)
                curr.removeLast();
                countMap.put(num, count);
            }
        }
    }
}