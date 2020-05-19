/*
	算法思想：
		双指针
*/
 

class Solution {
    public boolean validPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            //如果i,j不相等，则进行题目的要求，删除一个字符，删除一个字符分成两种情况，末尾左移一位/字符串头右移一位
            if(s.charAt(i) != s.charAt(j))
                return isPalindrome(s,i,j-1)||isPalindrome(s,i+1,j);
        }
        return true;
    }

    public boolean isPalindrome(String s,int i,int j){
        //此时再次进行判断，如果不满足情况则直接返回false
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}












