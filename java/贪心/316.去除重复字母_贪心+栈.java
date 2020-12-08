/*
	算法思想：
		贪心+栈，我只考虑了贪心，一个一个字符处理（比较麻烦），
		没有考虑栈（用其维护一个最小字典序！！）
		每遇到一个字符，如果这个字符不存在于栈中，就需要将该字符压入栈中。
		但在压入之前，需要先将之后还会出现，并且字典序比当前字符小的栈顶字符移除，然后再将当前字符压入。

		
		
		
		
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.contains(ch)) {
                continue;
            }
            //s.indexOf(str,index)，从index开始看是否存在这样的字符，即是否次数大于1！
            while (!stack.isEmpty() && stack.peek() > ch && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(ch);
        }
        char[] res = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return new String(res);
    }
}
