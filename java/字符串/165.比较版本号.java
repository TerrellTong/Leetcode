/*
	算法思想：
		直接按照题目要求即可，可以参考合并两个链表的思路
		在整数中，000 == 0 是true，可以不用清除前缀0
		按照"."进行拆分，s.split("\\.")



题解：
*/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int index1= 0;
        int index2= 0;
        while(index1 < s1.length || index2 < s2.length){
            String tmp1 = new String();
            String tmp2 = new String();
            if(index1 >= s1.length)
                tmp1 = "0";
            else 
                tmp1 = s1[index1];
            if(index2 >= s2.length)
                tmp2 = "0";
            else
                tmp2 = s2[index2];

            //清除零
            tmp1 = deleteZero(tmp1);
            tmp2 = deleteZero(tmp2);
            
            int i1 = Integer.valueOf(tmp1);
            int i2 = Integer.valueOf(tmp2);

            if(i1 > i2)
                return 1;
            else if(i1 < i2)
                return -1;
            else{
                index1++;
                index2++;
            }
        }
        return 0;
    }

    public String deleteZero(String s){
        if(s.length() > 1){
            StringBuilder res = new StringBuilder();
            int i=0;
            while(i < s.length()){
                if(s.charAt(i) == '0')
                    i++;
                else
                    break;
            }
            s = s.substring(i);
        }
        return s.length() == 0 ? "0" : s;
    }
}