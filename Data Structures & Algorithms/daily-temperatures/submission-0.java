class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
        stk.add(0);
        for(int i = 1; i < temperatures.length; ++i){
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]){
                res[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        return res;
    }
}
