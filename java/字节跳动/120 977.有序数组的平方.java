/*
	算法思想：
		双指针思想，忘记了！！！！！
		由于A是一个递增数组，要完成O(1)，因此我们需要双指针，进行判断，双指针，一个在头，一个在尾！
		之前没有考虑O(n)，直接用的Arrays.sort()!!!
		
	题解：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/  
	
*/


class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        for(int i=0,j=len-1,pos= len-1;i<=j;){
            if(A[i] * A[i] > A[j]*A[j]){
                ans[pos] = A[i] * A[i];
                i++;
            }else{
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}