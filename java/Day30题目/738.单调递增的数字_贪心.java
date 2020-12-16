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
        //将数字转成字符数组
        char[] n_arr = String.valueOf(N).toCharArray();
        int i = 1;
        //找到第一个不是递增的位置
        while(i < n_arr.length && n_arr[i-1] <= n_arr[i])
            i++;
        if(i < n_arr.length){
            while(i >= 1 && n_arr[i-1] > n_arr[i]){
                //高位-1
                n_arr[i-1] -= 1;
                //只将高位-1不能够，因为如果遇到339这样的，只对第二个3减1后，发现还是不满足条件
                //因此，我们要一直像这样循环，知道n_arr[i-1] < n_arr[i] 是递增的！！（我没考虑到的情况）
                i--;
            }
            //此时的i-1,i是递增的，我们将i后面的全部赋值为9
            for(i = i+1;i<n_arr.length;i++)
                n_arr[i] = '9';
        }
        //根据字符数组创建字符串
        return Integer.valueOf(new String(n_arr));
    }
}