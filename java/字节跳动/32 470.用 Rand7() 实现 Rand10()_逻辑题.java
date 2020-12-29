/*
	算法思想：
		逻辑题，(rand_X() - 1) × X + rand_X() ==> 可以等概率的生成[1, X * X]范围的随机数
		
题解：https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/  思路
		https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/xiang-xi-si-lu-ji-you-hua-si-lu-fen-xi-zhu-xing-ji/  题解！
*/


/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        //(rand_X() - 1) × X + rand_X() ==> 可以等概率的生成[1, X * X]范围的随机数

        int num = (rand7() - 1)*7 + rand7(); //rand49();
        // //如果不是10，就继续循环
        // while(num > 10)
        //     num =  (rand7() - 1)*7 + rand7();
        // return num;

        //优化
        //由于rand49 存在 41-49，因此我们要抛弃
        //由于20-40都是等概率出现的，我们一样可以使用，只需要取余即可
        while( num > 40)
            num = (rand7() - 1)*7 + rand7();
        return 1 + num%10; //+1为了解决 40%10为0的情况
    }
}