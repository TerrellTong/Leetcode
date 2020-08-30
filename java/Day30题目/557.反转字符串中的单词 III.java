/*
	算法思想：
		调用字符串翻转，然后初始化StringBuilder，完成题目要求
		
*/


class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                res += sb.reverse().toString();
                res += ' ';
                sb = new StringBuilder();
                continue;
            }
            sb.append(s.charAt(i));
            if(i == s.length()-1)
                res += sb.reverse().toString();
        }
        return res;
    }
}