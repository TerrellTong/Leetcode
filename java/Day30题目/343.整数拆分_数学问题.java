/*
	算法思想：
		数学问题，与剑指offer的剪绳子类似

		记住：大于4的时候，n每次减3，ans每次都要乘3
		返回值：ans与n进行相乘
*/

class Solution {
    public int integerBreak(int n) {
        int ans = 1;
        if(n<4) 
            return n-1; // n <  4时, 两数之和大于两数之积
        while(n>4){  // n=4时,3*1<3+1,但当n=5时,3*2>3+2
            n -= 3;
            ans *= 3;
        }
        return ans * n;  //最后返回的时候记得乘上最后剩下的n
    }
}