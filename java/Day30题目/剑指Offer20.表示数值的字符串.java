/*
	算法思想：
		简单实现，但是要正确归纳各种情况
		'.',只能出现一次，并且再此之前没有出现过e
		'e',只能出现一次，并且再此之前没有出现过e，而且已经出现了数字
		'+''-',只能在开头，或者紧跟在e后面
		
*/


class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for(int i=0;i<s.length();i++){
            //判定为数字，则标记numFlag
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                numFlag = true;
                //当i为'.'，且'.'再也没出现过,并且没有出现e
            else if(s.charAt(i) == '.' && !dotFlag && !eFlag)
                dotFlag = true;
                //当i为'e'，且再也没出现过e，并且再也没出现过数字了
            else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag){
                eFlag = true;
                numFlag = false;//为了避免出现123e这样的字符串
            }
            //判定为+-号，只能出现在第一位或者紧跟在e后面
            else if ((s.charAt(i) == '+' || s.charAt(i)=='-') && (i == 0 || s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E')){}
            //其他情况都是非法的
            else
                return false;
        }
        return numFlag;
    }
}