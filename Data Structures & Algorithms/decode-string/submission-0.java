class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch != ']') stk.push(ch);
            else {
                StringBuilder sb = new StringBuilder();
                while(!stk.isEmpty() && stk.peek() != '['){
                    if(stk.peek() >= 'a' && stk.peek() <= 'z'){
                        sb.append(stk.pop());
                    }
                }
                sb.reverse();
                stk.pop();

                int base = 1;
                int times = 0;

                while(!stk.isEmpty() && Character.isDigit(stk.peek())){
                    times = (stk.pop() - '0')*base + times;
                    base*=10;
                }

                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < times; i++){
                    temp.append(sb);
                }

                for(char c : temp.toString().toCharArray()){
                    stk.push(c);
                }
            }
        }
        while(!stk.isEmpty()) ans.append(stk.pop());

        ans.reverse();
        return ans.toString();
    }
}