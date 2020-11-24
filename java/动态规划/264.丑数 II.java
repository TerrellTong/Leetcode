/*
	算法思想：
		我们所有的丑数都是通过之前的丑数乘以 2, 3, 5 生成的，所以丑数序列可以看成下边的样子。

		1, 1×2, 1×3, 2×2, 1×5, 2×3, 2×4, 3×3...。

		我们可以把丑数分成三组，用丑数序列分别乘 2, 3, 5 。


		乘 2: 1×2, 2×2, 3×2, 4×2, 5×2, 6×2, 8×2,9×2,…
		乘 3: 1×3, 2×3, 3×3, 4×3, 5×3, 6×3, 8×3,9×3,…
		乘 5: 1×5, 2×5, 3×5, 4×5, 5×5, 6×5, 8×5,9×5,…
		
		合并有序数组，用归并的思想！！！

作者：windliang
链接：https://leetcode-cn.com/problems/ugly-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		
*/

class Solution {
    public int nthUglyNumber(int n) {
        //声明一个存储丑数的int数组n
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0,index3 = 0,index5 = 0;//三个指针
        for(int i=1;i<n;i++){
            //记录每个丑数与其相乘后的结果
            int factor2 = 2 * ugly[index2];
            int factor3 = 3 * ugly[index3];
            int factor5 = 5 * ugly[index5];
            //从这三个中选择最小的
            int min = Math.min(Math.min(factor2,factor3),factor5);
            //更新丑数序列
            ugly[i] = min;
            //确保不会添加重复元素
            if(factor2 == min)
                index2++;
            if(factor3 == min)
                index3++;
            if(factor5 == min)
                index5++;
        }
        return ugly[n-1];
    }
}