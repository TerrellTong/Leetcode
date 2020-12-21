/*
	算法思想：
		之前做过，相当于二刷成功，贪心+栈！！
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        //维护一个类似于单调递增的栈
        for(int i = 1; i<s.length();i++){
            char c = s.charAt(i);
            //如果此时栈中包含之前的元素，则直接出栈
            if(stack.contains(c))
                continue;
            else{
                //如果当前栈顶小于要入栈的元素
                //则把当前元素入栈
                if(stack.peek() < c){
                    stack.push(c);
                }else{
                    //s.indexOf(stack.peek(),i)，判断要出栈的元素，在当前位置之后是否还存在该元素
                    while(!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(),i) != -1){
                        stack.pop();
                    }
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}