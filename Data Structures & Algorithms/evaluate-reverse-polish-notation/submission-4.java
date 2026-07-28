class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            switch(s) {
                case("+"):
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b+a);
                    break;
                case("-"):
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;
                case("*"):
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b*a);
                    break;
                case("/"):
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        return stack.pop();
        
    }
}