/*
	算法思想：
		递归，分治
	解析：
	https://leetcode-cn.com/problems/powx-n/submissions/
*/
 
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x,N) : 1.0/quickMul(x,-N);
    }

    public double quickMul(double x,long N){
        if(N == 0)
            return 1.0;
        //分治
        double y = quickMul(x,N/2);
        //N是偶数，直接相乘，N是奇数，还要多乘以一个x
        return N % 2 == 0 ? y*y : y*y*x;
    }
}











