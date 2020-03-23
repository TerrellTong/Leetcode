//模拟栈的思想来进行整数位数反转的计算
/*
	溢出处理：
	从rev * 10 + pop > MAX_VALUE这个溢出条件来看
	   当出现 rev > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
	   当出现 rev == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
	从rev * 10 + pop < MIN_VALUE这个溢出条件来看
	   当出现 rev < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
	   当出现 rev == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数

*/
class Solution {
    public int reverse(int x) {
        int pop;//存储出栈后的数字
        int rev=0;//存储进栈后的数字
        //模拟栈的弹入和弹出
       //若条件是%10（若存在能被10整除的数，取余后为0），则不会进入循环
        while(x != 0){
            pop = x%10;
            x=x/10;
            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            //由于x是未知的，我们不能够把rev直接按照一个固定的数来进行乘，我们应该采用循环（迭代）的思想来慢慢的将第一次入栈的值往前移
            rev = rev*10+pop;
    }
    return rev;
    }
}