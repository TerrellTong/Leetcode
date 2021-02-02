/*
	算法思想：
		知道是滑动窗口的类型，但是自己还是不能ac，主要问题是收缩窗口的条件出了问题，
		我自己是直接将left放到当前不满足字符而且count为0，这样ABBB,k=2就不能实现！！
*/


class Solution {
    public int characterReplacement(String s, int k) {
        //滑动窗口
        int left = 0;
        int right = 0;
        int res = 0;
        int maxCount = 0;

        int[] count = new int[26];

        while(right < s.length()){
            //右边界的字符进行计数统计
            count[s.charAt(right)-'A']++;
            //维护maxCount,每右边移动一次边界，便读入一个字符，字符的频数会增加，这样就会使得maxCount更新
            maxCount = Math.max(maxCount,count[s.charAt(right)-'A']);
            right++;
			
			//窗口何时收缩，收缩条件
            //right-left为窗口的大小，maxCount+k表示如果是当前maxCount+改了k次之后的窗口大小
            //如果right-left比maxCount+k大，则说明不能完全替换掉不同的字母，此时需要窗口收缩
            while(right - left > maxCount + k){
                //左窗口右移动
                count[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res,right-left);
        }

        return res;
    }
}