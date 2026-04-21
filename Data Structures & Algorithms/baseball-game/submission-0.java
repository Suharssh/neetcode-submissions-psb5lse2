class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < operations.length; i++){
            if(operations[i].equals("+")){
                int top1 = stk.peek();
                stk.pop();
                int top2 = stk.peek();
                stk.push(top1);
                stk.push(top1+top2);

            }
            else if(operations[i].equals("C")){
                stk.pop();
            }
            else if(operations[i].equals("D")){
                stk.push(stk.peek()*2);
            } else {
                stk.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        while(!stk.isEmpty()){
            sum+=stk.peek();
            stk.pop();
        }
        return sum;
    }
}