/*
	算法思想：
		之前做过，用第一个作为common，然后截断即可！

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0)
            return "";
        String common = strs[0];

        for(int i = 1;i<len;i++){
            
            for(int j=0;j<common.length();j++){
                char c = j<strs[i].length() ? strs[i].charAt(j) : ' ';
                if(common.charAt(j) != c){
                    common = common.substring(0,j);
                }
            } 
        }
        return common;
    }
}