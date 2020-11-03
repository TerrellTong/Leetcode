/*
	算法思想：
		我的思想：之前做过类似的，陷入了思维定式，这个是判断是否有一个山峰！
		
		题解：i从左边开始上坡，j从右边开始爬坡，判断到达的山峰顶点是否为同一个！！
		
		比较简单，陷入了思维定式！！！

*/

class Solution {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;

        //从左往右找
        while(left + 1 < len && A[left] < A[left+1]){
            left++;
        }

        //从右往左找
        while(right > 0 && A[right-1] > A[right]){
            right--;
        }
        //判断找的山峰是否是同一个！
        return left > 0 && right < len-1 && right == left;
    }
}