/*
	算法思想：
		相当于是求数组字符串A中的，字符交集
		
		首先，将字符串数组的第1个字符串取出，并将该字符串的每个字符放入charCount数组中，用于计数保存，
		当遍历到第二个字符串时，我们采取同样的方法，只是将此时的char数组，与charCount数组中的值进行比较，然后取出较小值即可！
		
图：https://leetcode-cn.com/problems/find-common-characters/solution/1002-cha-zhao-chang-yong-zi-fu-ha-xi-fa-jing-dian-/
题解：https://leetcode-cn.com/problems/find-common-characters/solution/1002cha-zhao-chang-yong-zi-fu-by-111-101/
*/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList();
        //存取26个字母
        int[] charCount = new int[26];
        for(char c : A[0].toCharArray()){
            charCount[c-'a']++;
        }
        for(int i=1;i<A.length;i++){
            //存取26个字母
            int[] curCount = new int[26];
            //遍历第i个字符串的所有字符
            for(char c : A[i].toCharArray())
                curCount[c-'a']++;
            
            //将此时第i个字符串的情况与charCount比较，取最小的
            for(int j = 0;j<26;j++){
                charCount[j] = Math.min(charCount[j],curCount[j]);
            }
        }
        for(int i=0;i<charCount.length;i++){
            while(charCount[i] != 0){
                res.add(String.valueOf((char)(i+'a')));
                charCount[i]--;
            }
        }
        return res;
    }
}
