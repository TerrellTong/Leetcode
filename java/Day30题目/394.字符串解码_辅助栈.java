/*
	算法思想：
		辅助栈，如果遇到字符，则放入sb中，遇到数字，则放到num中；
		如果遇到[，则num入NumStack，sb入strStack，并且num,sb全部清空
		如果遇到],则把strStack的栈顶弹出，用preSb暂存，并且弹出numStack（倍数），然后把sb,放到preSb之后。
		最后preSB 赋给 sb
		
*/
 
class Solution {
    public String decodeString(String s) {
        //初始化两个栈，一个num栈，一个str栈
        LinkedList<Integer> numStack = new LinkedList();
        LinkedList<String> strStack = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9')
                //担心前面的系数是大于10，因此要用num*10来解决此情况
                num = num*10 +  c - '0';
            else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                sb.append(c);
            else if(c == '['){
                if(num > 0)
                    numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                num = 0;
            }else{
                StringBuilder preSB = new StringBuilder().append(strStack.pop());
                int times = numStack.pop();
                for(int j=0;j < times;j++)
                    preSB.append(sb);
                sb = preSB;
            }
        }
        return sb.toString();
    }
}








