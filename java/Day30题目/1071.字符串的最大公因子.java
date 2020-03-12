 /*
	算法思想：
	辗转相除法，以字符串的长度作为a,b找出他们的最大公约数，此时这个数就是str的子串长度

 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
         // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));

    }
    private int gcd(int a, int b){
       while(b != 0){
           int tmp = b;
           b = a%b;
           a = tmp;
       }
       return a;
   }
}
