/*
	题目描述：
		给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
	
	算法思想：
		因为，每个数的每位上只能是0或1，那个位置上的数据已经最大了。那么就最少需要N个数据，且这个位上全是1
		
		比如82734，最大数据是8，用8个11111加起来等于88888，是可以组合的 （然后再进行相应的更改即可得到82734）！

		
题解：https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/solution/shui-jie-shi-xia-ti-mu-wo-mei-du-dong-ti-vgga/
*/

class Solution {
    public int minPartitions(String n) {
        int res = 0;
        //直接找到最大的数
        for(int i=0;i<n.length();i++){
            if(n.charAt(i) == '9')
                return 9;
            else
                res = Math.max(n.charAt(i)-'0',res);
        }
        return res;
    }
}
