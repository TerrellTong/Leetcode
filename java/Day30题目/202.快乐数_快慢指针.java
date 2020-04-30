/*
	算法思想：
		快慢指针
*/
 
class Solution {
    public int squareNum(int n){
        //sum记录每个位的平方和
        int sum=0;
        while(n > 0){
            //取最后一位的数字
            int digit = n%10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        //快慢指针，快指针在慢指针的后一位，慢指针移动一步，快指针移动两步
        int slow = n;
        int fast = squareNum(n);
        //两个指针遇到一起，说明是环/到了尾部
        while(slow != fast){
            slow = squareNum(slow);
            //快指针移动两步
            fast = squareNum(squareNum(fast));
        }
        return slow == 1;
    }
}












