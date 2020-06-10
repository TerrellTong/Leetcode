/*
	算法思想：
		双指针，二刷
	
*/
 
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
		//将数字转换成字符串
        String str = String.valueOf(x);
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
}



//翻转一半的数字，答案
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int temp = x;
        int rev =0 ;
        //存储翻转后的数字
        int pop = 0;
        while(x != 0){
            pop = x%10;
            x= x/10;
            rev = rev*10 + pop;
        }
        if(rev == temp)
            return true;
        return false;

    }
}


