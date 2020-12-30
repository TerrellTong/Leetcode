/*
	算法思想：
		直接做过，终于二刷成功了！！！
		遇到左括号，将对应的右括号入栈，如果是右括号，弹出当前栈顶，判断是否相等
*/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c:s.toCharArray()){
            //如果遇到左括号，将对应的右括号入栈
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else{
                //此时是右括号
                if(!stack.isEmpty() && stack.pop() == c)
                    continue;
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}