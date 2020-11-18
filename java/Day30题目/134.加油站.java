/*
	算法思想：
		从一个点开始，然后依次走到下一个结点，判断是否能回到原点！！！
	
题解：https://leetcode-cn.com/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++){
            int j = i;
            int remain = gas[i];
            //当前剩余的油能否到达下一个点
            //从一个点开始，然后依次走到下一个结点，判断是否能回到原点！
            while(remain - cost[j] >= 0){
                //减去花费的加上新补给的
                remain = remain- cost[j] + gas[(j+1) % n];
                j = (j+1) % n;
                if(j == i){
                    return i;
                }
            }
        }
        return -1;
    }
}