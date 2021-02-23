/*
	算法思想：
		滑动窗口，AC，读懂题意即可！
*/


class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left = 0;
        int right = 0;
        //记录老板如果不控制情绪，则可以留住多少人
        int totalCustomer = 0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i] == 0)
                totalCustomer += customers[i];
        }
        
        int maxCustomer = Integer.MIN_VALUE;
        while(right < customers.length){
            //如果当前老板生气，则进行忍耐，此时可以留住用户
            if(grumpy[right] == 1){
                totalCustomer += customers[right];
            }
            right++;
            //如果窗口大于等于生气的时间，即X分钟不生气，则窗口缩小
            while(right-left >= X){
                maxCustomer = Math.max(totalCustomer,maxCustomer);
                //窗口收缩的时候，如果要移除的为生气的，我们应该将totalCustomer - 当前用户
                if(grumpy[left] == 1){
                    totalCustomer -= customers[left];
                }
                left++;
            }
        }
        return maxCustomer;
    }
}