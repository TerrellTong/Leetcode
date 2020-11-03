/*
	算法思想：
		递归，存在两种切割，1）s1切割成两个部分，然后进行若干步切割交换，最后判断是否能变成s2的两个部分
							2）S1 切割并且交换为两部分，然后进行若干步切割交换，最后判断两个子树是否能变成 S2 的两部分。

题解：https://leetcode-cn.com/problems/scramble-string/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-2/

*/

class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }

        //判断两个字符串每个字母出现的次数是否一致
        int[] letters = new int[26];
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        //如果两个字符串的字母出现不一致直接返回false
        for(int i=0;i<26;i++){
            if(letters[i] != 0)
                return false;
        }

        //遍历每个切割的位置
        for(int i=1;i<s1.length();i++){
            //对应情况1，判断s1的子树是否能变为s2相应部分
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
                return true;
            //对应情况2，s1的两个子树交换，然后判断s1的子树能否变成s2的相应部分
            if(isScramble(s1.substring(i),s2.substring(0,s2.length()-i)) && isScramble(s1.substring(0,i),s2.substring(s2.length()-i)))
                return true;
        }
        return false;
    }
}