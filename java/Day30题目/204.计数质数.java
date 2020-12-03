/*
	算法思想：
		埃氏筛
		如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,,… 一定不是质数，因此我们可以从这里入手。
		当然这里还可以继续优化，对于一个质数 x，如果按上文说的我们从 2x 开始标记其实是冗余的，
		应该直接从 x * x 开始标记，因为 2x,3x,… 这些数一定在 x 之前就被其他数的倍数标记过了，例如  的所有倍数，3 的所有倍数等。



题解：https://leetcode-cn.com/problems/count-primes/solution/kuai-lai-miao-dong-shai-zhi-shu-by-sweetiee/
	https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
*/

class Solution {
    public int countPrimes(int n) {
        //把所有的数字都设置为素数
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim,true);
        //从2开始枚举到sqrt(n)
        for(int i=2;i * i < n;i++){
            //如果当前是素数
            if(isPrim[i]){
                //把当前数的倍数
                for(int j=i*i;j<n;j+=i)
                    isPrim[j] = false;
            }
        }

        int res = 0;
        for(int i=2;i<n;i++){
            if(isPrim[i])
                res++;
        }
        return res;
    }
}