class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            char compare = ' ';
            switch(c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        compare = stack.pop();
                    }
                    if (compare != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty()) {
                        compare = stack.pop();
                    }
                    if (compare != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty()) {
                        compare = stack.pop();
                    }
                    if (compare != '{') {
                        return false;
                    }
                    break;
            }

        }

        return stack.isEmpty();
    }
}