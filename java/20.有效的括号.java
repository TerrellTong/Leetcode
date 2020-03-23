//栈的思想：遇到左括号，就把其右括号入栈，然后遇到了右括号，将栈中的元素弹出，判断是否相等！

class Solution {
    public boolean isValid(String s) {
        //字符串为空，就直接返回
        if(s.isEmpty())
            return true;
        //创建一个栈
        Stack<Character> stack = new Stack<Character> ();
        //将字符串转换为字符数组，然后将左括号入栈
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || c != stack.pop())
                return false;
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}