/*
	算法思想：
		栈，之前看了，还是不会！！！！
		当遇到左括号时，入栈左括号的下标，当遇到右括号时，出栈，如果栈为空，记录当前的下标，方便求栈的长度！！
		
	题解：https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/  之前做过，还是错了！
	
*/


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        //
        stack.push(-1);
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //如果是'('，则把左括号的下标入栈
            if(c == '(')
                stack.push(i);
            else{
                //栈顶元素弹出
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    max = Math.max(max,i-stack.peek());
            }
        }
        return max;
    }
}