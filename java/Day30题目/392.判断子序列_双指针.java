/*
	算法思想：
		双指针
	自己想的太复杂了！！！
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        //s的长度 小于 t的长度！
        int n = s.length(),m = t.length();
        int i=0,j=0;
        while(i < n && j <m){
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i==n;
    }
}