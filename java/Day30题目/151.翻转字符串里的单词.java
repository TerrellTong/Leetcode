/*
	算法思想：
		简单的API方法的熟悉subString ()!!! 求子串！！！
				
*/

class Solution {
    public String reverseWords(String s) {
        s = s.trim();//删除首尾空白字符串;
        int len = s.length()-1;
        int i=len;
        int j=i;
        StringBuilder sb = new StringBuilder();
        while(i>=0){
            //逆序遍历，找到第一个" "
            while( i>=0 && s.charAt(i) != ' ') i--;
            //添加单词
            sb.append(s.substring(i+1,j+1)+" "); 
            //跳过单词间多余的空格
            while(i>=0 && s.charAt(i) == ' ') i--;
            //将j标记为下一个单词
            j=i;
        }
        return sb.toString().trim();
    }
}












