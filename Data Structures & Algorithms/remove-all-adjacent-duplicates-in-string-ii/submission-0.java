class Solution {
    public String removeDuplicates(String s, int k) {

        
        // this code wont work, as we have to remember the characters which 
        // came before. eg - abbba

        // in this our count will be 1 once we push a, count = 1,
        // once b comes, count = 1 for the new char 'b'

        // now all 3 b's come and go now the stack has a, the next a comes,
        // count becomes 1 but infact the count must be 2 as there are 2 a's
        

        // Stack<Character> stk = new Stack<>();
        // for(char ch : s.toCharArray()){
        //     int count = 0;
        //     if(!stk.isEmpty() && stk.peek() == ch){
        //         count++;
        //         if(count == k){
        //             stk.pop();
        //         }
        //     } else {
        //         stk.push(ch);
        //     }
        // }
        // StringBuilder res = new StringBuilder();
        // while(!stk.isEmpty()){
        //     res.append(stk.pop());
        // }

        // return res.reverse().toString();

        // USE PAIRS
        
        // Stack to store the character with its count
        Deque<Pair> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // If the character is same as the character at top, increase the count of top character
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            }
            // If the character is different from the character at top, push the character to the top
            else {
                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder result = new StringBuilder();

        // Construct the result string
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int i = 0; i < p.count; i++) {
                result.append(p.character);
            }
        }

        return result.reverse().toString();
    
    }
}
class Pair {
    char character;
    int count;

    Pair(char character, int count) {
        this.character = character;
        this.count = count;
    }
}