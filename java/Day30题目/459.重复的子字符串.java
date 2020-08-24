/*
	算法思想：
		如果想从i，开始切断，那么子串的长度一定会是s长度的i倍
		由于会重复，因此子串的长度不会是s长度的两倍，因此我们只需要比较一半即可！
		
题目思路：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
*/


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=1;i * 2 <= n;i++){
            if(n % i == 0){
            boolean match = true;
            for(int j=i;j<n;j++){
                if(s.charAt(j) != s.charAt(j-i)){
                    //如果存在不相等，则match置为false，并退出循环
                    match = false;
                    break;
                }
            }
            if(match)
                return true;
            }
        }
        return false;
    }
}