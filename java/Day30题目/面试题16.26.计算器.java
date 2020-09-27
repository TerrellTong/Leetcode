/*
	算法思想：
		只需要一个栈，存储数字即可，
		当遇到-，就把-num放入栈中。*，就把栈顶元素 * num放入栈中
		在最后，栈中的元素默认执行加法操作！
		
*/


class Solution {
    public int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int ans = 0, i = 0;
        while(i < cs.length){
            if(cs[i] == ' '){
                i++;
                continue;
            }
            char tmp = cs[i];

            //如果是运算符，则i++
            if(tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-'){
                i++;
                //如遇到空格，继续后移
                while(i < cs.length && cs[i] == ' ')
                    i++;
            }

            int num = 0;
            //isDigit()判断字符是否是数字
            //此时是计算，下一个运算符前的字节，所代表的int为多少
            //如果遇到了tmp为运算符，此时由于i++，因此num是运算符后的数字！
            while(i < cs.length && Character.isDigit(cs[i])){
                num = num * 10 + cs[i] - '0';
                i++;
            }
            //如果是- 则把-num放入栈中
            switch(tmp){
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);   
        }

        //如果栈不空，那么就将里面的值相加
        while(!st.isEmpty())
            ans += st.pop();
        return ans;
    }
}