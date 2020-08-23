/*
	算法思想：
		位运算！！！
		由于从m到n,如果没有公共子串，则进行&之后，那一位一定会是0，因此我们只需要找到，右移到公共子串所需要的位数，然后进行左移得到结果！
		
题目思路：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/
*/


class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        //找到公共前缀，
        while(n > m){
            zeros++;
            m >>= 1;
            n >>= 1;
        }
        return m<<zeros;
    }
}