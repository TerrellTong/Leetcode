/*
	算法思想：
		对于遇到左括号，需要从下一个索引开始递归！特别处理！！
		非数值位时，将缓存值根据操作符进行计算并置零缓存;
		
		遇到右括号, 记录阶段计算的值, 并跳过本阶段(括号范围)的索引;
		尾部时缓存位不为0则计算最终结果。
		
		可以参考基本计算器II
	
题解：https://leetcode-cn.com/problems/basic-calculator/solution/zhu-yi-jiao-biao-izai-jin-ru-di-gui-shi-z3sl6/
解题思路 https://leetcode-cn.com/problems/basic-calculator/solution/2ms-100382-9821-by-getouo-39zo/
	
*/

class Solution {
    public int calculate(String s) {
        return help(s);
    }

    int i = 0;//全局变量，因为字符串S中的位置
    public int help(String s){
        int num = 0;
        char LastOp = '+';
        Stack<Integer> stack = new Stack();
        while(i < s.length()){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = 10 * num + cur - '0';
            }
            if(cur == '('){
                i++;
                num = help(s);
            }
            
            if((!Character.isDigit(cur) && cur!= ' ') || i== s.length()-1){
                if(LastOp == '+')
                    stack.push(num);
                else if(LastOp == '-')
                    stack.push(-num);
                num = 0;
                LastOp = cur;
            }
            //必须要放到后面，因为要将最后一个括号前的数字，压入栈中
            if(cur == ')')
                return sum(stack);
            i++;
        }
        return sum(stack);
    }

    public int sum(Stack number){
        int res = 0;
        while(!number.isEmpty())
            res += (int)number.pop();
        return res;
    }
}