/*
	算法思想：
		如果两个字符串的长度是n1,n2，那么其相乘的结果最大长度不会超过n1+n2！
		我们直接将结果放入数组即可
		其第一位（进位）位于 res[i+j]，第二位（应在的位置）位于 res[i+j+1]。
		
		之前的每日一题，还是不会！！
	
题解：https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
	
*/

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();

        int m = num1.length();
        int n = num2.length();
        int[] c = new int[m+n];
        //模拟字符串相乘
        for(int i=num1.length()-1;i>=0;i--){
            int curi = num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                    int curj = num2.charAt(j)-'0';
                    int res = curi * curj + c[i+j+1];
                    //第一位位于c[i+j]，第二位位于c[i+j+1]
                    c[i+j+1] = res % 10;
                    c[i+j] += res / 10;
            }
        }
        for(int i=0;i<c.length;i++){
            if(i==0 && c[i] == 0)
                continue;
            sb.append(c[i]);
        }
        return sb.toString();
    }
}