/*
	算法思想：
		对工具函数的运用 Character.isLetterOrDigit /  Character.toLowerCase
	
*/
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        //将字符和数字放到一个新的StringBuilder中
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            //如果该字符是字符/数字，则添加到sb中，用来排除特殊字符
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        //用新的StringBuilder进行判断,双指针判断
        int sb_len = sb.length();
        int i=0, j=sb_len-1;
        while(i<j){
            //将大写字符转成小写
            if(Character.toLowerCase(sb.charAt(i)) != Character.toLowerCase(sb.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}



