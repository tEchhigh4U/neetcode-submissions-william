class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (String op : operations) {
            if (op.equals("+")){
                // If the stack is empty, stack.pop() will throw EmptyStackException.
                int last = stack.pop();
                // If you only want to look at the top without removing it, use stack.peek() instead.
                int secondLast = stack.peek();
                int newScore = last + secondLast;
                stack.push(last);
                stack.push(newScore);
                sum += newScore;
            } else if (op.equals("C")) {
                int removed = stack.pop();
                sum -= removed;
            } else if (op.equals("D")) {
                int last = stack.peek();
                int doubled = last * 2;
                stack.push(doubled);
                sum += doubled;
            } else {
                int score = Integer.parseInt(op);
                stack.push(score);
                sum += score;
            }
        }
        return sum;
    }
}