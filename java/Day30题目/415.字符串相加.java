/*
	算法思想：
		与之前的链表相加类似！
*/

class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int i=len1-1,j=len2-1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int num1_i = (i>=0) ? num1.charAt(i) - '0' : 0;
            int num2_j = (j>=0) ? num2.charAt(j)-'0' : 0;
            //计算结果
            int res = num1_i + num2_j + flag;
            //计算是否进位
            flag =  res / 10;
            res = res % 10;
            //将int强转为char
            sb.append((char)(res+'0'));
            i--;
            j--;
        }
        //如果加完之后出现了进位的情况
        if(flag != 0){
            sb.append((char)(flag+'0'));
        }
        return sb.reverse()+"";
    }
}