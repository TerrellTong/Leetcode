/*
	算法思想：
		简单的都不会！！！！，之前还做过，我是没有考虑i ,j 一个为空怎么办，没有继续想 相加
*/

class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while(i >= 0 || j >= 0){
            int cur_i = (i>=0) ? num1.charAt(i) - '0' : 0;
            int cur_j = (j>=0) ? num2.charAt(j) - '0' : 0;
            int sum = cur_i + cur_j + flag;
            flag = sum / 10;
            sb.append((char)((sum%10)+'0'));
            i--;
            j--;
        }
        if(flag != 0)
            sb.append((char)(flag + '0'));
        return sb.reverse().toString();
    }
}