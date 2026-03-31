class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            // Step 1: Push opening brackets
            if (ch == '(' || ch == '{' || ch == '['){
                stack.add(ch);   
            } 
            // Step 2: Handle closing brackets
            else if (ch == ')' || ch == '}' || ch == ']'){
                if (stack.isEmpty()){ //❌ stack == null → should be stack.isEmpty() 
                    return false;
                }

                char top = stack.pop(); //get the last opened bracket

                // Step 3: Check if it matches
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')){
                        return false;
                    }
            }

            
        }

        // Step 4: stack should be empty if all brackets matched
        return stack.isEmpty();
    }
}
