class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.add(')');
            } else if (ch == '{') {
                stack.add('}');
            } else if (ch == '[') {
                stack.add(']');
            } else {
                if (stack.isEmpty()) return false;
                char expected = stack.remove(stack.size() - 1);
                if (ch != expected) return false;
            }
        }
        return stack.isEmpty();
    }
}
