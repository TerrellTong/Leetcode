/*
	算法思想：
		计数贪心，每次统计每个字母出现的次数，然后出现最多的那个字母必须放到偶数下标，不然会出现相邻的情况
		如果可以重新排布成相邻的字母都不相同的字符串，每个字母最多出现 (n+1)/2 次。（阈值）！

题解：https://leetcode-cn.com/problems/reorganize-string/solution/zhong-gou-zi-fu-chuan-by-leetcode-solution/
	https://leetcode-cn.com/problems/reorganize-string/solution/javadai-ma-ji-bai-liao-100de-yong-hu-by-sdwwld/
*/

class Solution {
    public String reorganizeString(String S) {
        int[] charCount = new int[26];
        //记录S中每个字符出现的次数
        for(char c : S.toCharArray())
            charCount[c-'a']++;
        
        int max = 0,maxAlpaCharIndex = 0;
        int threshold = (S.length()+1)>>1;
        for(int i=0;i<26;i++){
            if(charCount[i] > max){
                max = charCount[i];
                //记录最大字符出现的位置
                maxAlpaCharIndex = i;
            }
            //如果出现的次数大于了极限，则直接返回
            if(max > threshold)
                return "";
        }

        char[] res = new char[S.length()];
        //把最大值的字符，放在偶数位置！！！
        int index = 0;
        while(charCount[maxAlpaCharIndex]-- > 0){
            
            res[index] = (char)(maxAlpaCharIndex + 'a');
            index += 2;
        }

        for(int i=0;i<26;i++){
            while(charCount[i]-- > 0 && charCount[i] < 500){
                if(index >= S.length())
                    index = 1;
                res[index] = (char)(i+'a');
                index += 2;
            }
        }
        return new String(res);
}
}