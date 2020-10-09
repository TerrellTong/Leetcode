/*
	算法思想：
		快慢指针，好像环的题目做过
*/

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len-1;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] =tmp;
            left++;
            right--;
        }
    }
}