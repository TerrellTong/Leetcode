/*
	算法思想：
		贪心，自己考虑过，但是对于331之类的无法解决，因为我是在不满足递增位置之前就直接计算出了结果，因此不方便修改
		贪心的思路是当不满足递增时，就把后面的值赋值为9，（get了）
		但是对于之前出现相同的数没有解决！！
		
		题解的思想时，不动，直接从原字符上进行修改
		当遇到不满足递增的情况，我们把高位-1后，还要继续进行判断strN[i-1] > strN[i]!!;
题解：https://leetcode-cn.com/problems/monotone-increasing-digits/solution/dan-diao-di-zeng-de-shu-zi-by-leetcode-s-5908/
*/


class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i=1;
        //找到第一个不满足递增的位置
        while(i < strN.length && strN[i-1] <= strN[i]){
            i++;
        }
        if(i < strN.length){
            while(i > 0 && strN[i-1] > strN[i]){
                strN[i-1] -= 1;
                i--;
            }
            for(i = i+1;i<strN.length;i++)
                strN[i] = '9';
        }
        return Integer.valueOf(new String(new String(strN)));
    }
}