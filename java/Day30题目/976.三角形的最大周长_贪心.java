/*
	算法思想：
		贪心，我自己考虑的是考虑从数组中选三个，然后满足任意两边之和大于第三遍的条件，但是，有的大测试用例不能通过！！！
		
		直接对数组进行排序，然后由于数组是升序排列，因此只需要前两个的和大于第三个就可以了！！，减少了比较量！！

*/

class Solution {
    public int largestPerimeter(int[] A) {
        //将A进行升序排列，因此只需要前两个的和大于第三个就可以了！！
        Arrays.sort(A);
        //为了找到最大的周长，因此，我们需要倒序，这样找到的就是最大值！
        for(int i=A.length-1;i>=2;i--){
            if(A[i-1] + A[i-2] > A[i])
                return A[i-1] + A[i-2] + A[i];
        }
        return 0;
    }
}