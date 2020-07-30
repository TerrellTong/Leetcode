/*
	算法思想：
		用栈进行判断，如果是左括号，则对应的右括号入栈！！！！
		二刷时只知道用栈判断，括号的入栈问题还是没解决！！
	
*/

class Solution {
    public boolean isValid(String s) {
        //判断字符串是否为空
        if(s.isEmpty())
            return true;
        //创建一个栈用于存储括号数组
        Stack<Character> stack = new Stack();
        for(Character c : s.toCharArray()){
            //如果是左括号，则对应的右括号入栈
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
			//如果栈为空或者
            else if(stack.isEmpty()|| c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}