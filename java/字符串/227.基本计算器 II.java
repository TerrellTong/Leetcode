/*
	算法思想：
		栈的思想，知道，之前好像做过，但是自己实现还是有问题
		1）必须要记住上一次的OP，默认的上一次OP为+
		2）不是遇到了+，-，*，/就立马加，是等某个数字确实走到了头再计算 例如 0-232323！
		3）根据数字，从而计算上一次的OP！
		题型类似  面试题 16.26. 计算器  ，相当于二刷！！
		
*/

class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack();
        //默认上一次的运算符是'+'
        char LastOP = '+';

        int i = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int tmp = 0;
                //此时遍历每一个字符是数字的情况
				//0-343435，需要一直遍历到5，才算把数字结束
                while( i < s.length() && Character.isDigit(s.charAt(i))){
                    tmp = tmp*10 + s.charAt(i) - '0';
                    i++;
                }
                //获取每一个数字后，判断lastOP的情形
                if(LastOP == '+')
                    stack.push(tmp);
                else if(LastOP == '-')
                    stack.push(-tmp);
                else if(LastOP == '*'){
                    int a = stack.pop();
                    stack.push(a*tmp);
                }else{
                    int a = stack.pop();
                    stack.push(a/tmp);
                }
            }else if(s.charAt(i) == ' '){
                i++;
            }
            else{
                LastOP = s.charAt(i);
                i++;
            }

        }

        int res = 0;
        while(!stack.isEmpty())
            res += stack.pop();

        return res;
    }   
}
