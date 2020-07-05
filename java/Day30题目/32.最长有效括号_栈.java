/*
	算法思想：
		对于这种括号匹配问题，一般都是使用栈，左括号入栈
		我们先找到所有可以匹配的索引号，然后找出最长连续数列！
		//()(())),
		
https://leetcode-cn.com/problems/longest-valid-parentheses/solution/shou-hua-tu-jie-zhan-de-xiang-xi-si-lu-by-hyj8/
*/
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        //压入-1用于表示参照物，如果不添加的话，则当最后一个）匹配后，栈为空，此次栈的长度无法计算了
        stack.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                //把左括号的索引压入栈
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
					//栈长度的计算方式：当前索引-出栈后新栈的栈顶索引
                    max = Math.max(max,i-stack.peek());
            }
        }
        return max;
    }
}
    





