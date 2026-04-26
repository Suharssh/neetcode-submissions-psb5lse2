class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while(i < asteroids.length){
            if(stk.isEmpty() || stk.peek() < 0 || asteroids[i] > 0){
                stk.push(asteroids[i]);
                i++;
                continue;
            }
            if(Math.abs(asteroids[i]) < stk.peek()){
                i++;
            } else if(Math.abs(asteroids[i]) > stk.peek()){
                stk.pop();
            } else {
                stk.pop();
                i++;
            }
        }
        return stk.stream().mapToInt(x -> x).toArray();
    }
}