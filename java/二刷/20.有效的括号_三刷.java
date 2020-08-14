/*
	算法思想：
		三刷，成功解决了！
		使用栈的思想！
*/

class Solution {
    public boolean isValid(String s) {
        //放入一个栈用于存储')'
        Stack<Character> stack = new Stack();
        //开始遍历String的每个字符
        for(int i=0;i<s.length();i++){
            //如果遇到左括号，则对应的右括号入栈
            if(s.charAt(i) == '(')
                stack.push(')');
            else if(s.charAt(i) == '{')
                stack.push('}');
            else if(s.charAt(i) == '[')
                stack.push(']');
            else 
                //说明此时遇到了右括号,且栈顶的右括号与其不相等，则直接返回false
                //如果此时遇到右括号，且栈为空，说明之前没有左括号匹配，则返回false
                if(stack.isEmpty() || stack.pop() != s.charAt(i))
                    return false;
        }
        return stack.isEmpty();
    }
}