/*
	算法思想：
		尽可能优先使用较大数值对应的字符，最后转换得到的罗马数字的字符个数更少，（贪心思想！！） 从左往右思考
		我是按照从右到左想的！，即每次都是考虑的个位！！
		

题解：https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-zui-zhi-guan-de-jie-/
*/

class Solution {
    public String intToRoman(int num) {
        if(num < 1 || num > 3999)
            return null;
        //尽可能优先使用较大数值对应的字符
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] key = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(key[i]);
            }
        }
        return sb.toString();
    }
}