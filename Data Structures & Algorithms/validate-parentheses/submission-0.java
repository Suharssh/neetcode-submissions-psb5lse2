class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stk.push(s.charAt(i));
            else {
                if(stk.isEmpty()) return false;
                char ch = stk.pop();
                if((s.charAt(i) == ']' && ch != '[') ||
                   (s.charAt(i) == ')' && ch != '(') ||
                   (s.charAt(i) == '}' && ch != '{') ) return false;
                
            }
            
        }
        return stk.isEmpty();
    }
}
