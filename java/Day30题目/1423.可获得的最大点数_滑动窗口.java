/*
	算法思想：
		滑动窗口的思想，转换，窗口固定，由于只能拿开头和末尾的k张牌，因此剩下的连续n-k一定是连续的，我们只要这n-k个连续的数字最小
		因此，我们可以获得的点数就是最大的！
		
题解：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/solution/ke-huo-de-de-zui-da-dian-shu-by-leetcode-7je9/
*/


class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //窗口固定,求以n-k长度的窗口的最小和
        int left = 0,right = cardPoints.length-k;
        int Allsum = 0;
        for(int card:cardPoints){
            Allsum += card;
        }

        //记录窗口的总和
        int res = 0;
        for(int i=0;i<right;i++)
            res += cardPoints[i];

        int minSum = res;
        while(right < cardPoints.length-1){
            res += cardPoints[right];
            right++;
            res -= cardPoints[left];
            minSum = Math.min(minSum,res);
            left++;
        }
        return Allsum-minSum;
    }
}